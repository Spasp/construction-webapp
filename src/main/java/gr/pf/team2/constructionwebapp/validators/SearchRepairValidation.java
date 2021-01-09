package gr.pf.team2.constructionwebapp.validators;

import gr.pf.team2.constructionwebapp.forms.SearchForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class SearchRepairValidation implements Validator {

    private static final String AFM_PATTERN = "^[0-9]*$";
    private static final int AFM_SIZE = 9;

    @Override
    public boolean supports(Class<?> aClass) {
        return SearchForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        SearchForm repairSearchForm = (SearchForm) target;

        String startDate = repairSearchForm.getScheduledDateStart();
        String endDate = repairSearchForm.getScheduledDateEnd();
        String afm = repairSearchForm.getAfm();

        if (startDate.equals("") && endDate.equals("") && afm.equals("")) {                                            //ALL ATTRIBUTES CANNOT BE NULL
            errors.rejectValue("scheduledDateStart", "repairSearch.allTheAttributes.Are.Null");
        } else if ((startDate.equals("") && !endDate.equals("")) && afm.equals("")) {                                    //ONLY END DATE
            errors.rejectValue("scheduledDateEnd", "repairSearch.Only.EndDate");
        } else if ((!startDate.equals("")) && (!endDate.equals(""))) {                                               //END DATE SOONER THAT START DATE
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //ex: '1939-01-01'
            LocalDate sd = LocalDate.parse(startDate, formatter);
            LocalDate ed = LocalDate.parse(endDate, formatter);
            if (ed.isBefore(sd)) {
                errors.rejectValue("scheduledDateEnd", "repairSearch.endDate.isBiggerThan.startDate");
            }
        }



        if (!afm.equals("")) {
            if (afm.length() != 9) {
                errors.rejectValue("afm", "repairCreate.afmOwner.size.invalid");

            }
            if (!afm.matches(AFM_PATTERN)) {
                errors.rejectValue("afm", "createProperty.afm.pattern.invalid");
            }

        }


    }
}
