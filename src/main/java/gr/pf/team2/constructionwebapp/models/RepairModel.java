package gr.pf.team2.constructionwebapp.models;

import gr.pf.team2.constructionwebapp.domain.Property;
import gr.pf.team2.constructionwebapp.enums.StateOfRepair;
import gr.pf.team2.constructionwebapp.enums.TypeOfRepair;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RepairModel {

    private static final String COST_PATTERN = "(?!0\\.00)[1-9]\\d{0,9}(\\.(\\d|\\d\\d))?";
    private static final String AFM_PATTERN = "^[0-9]*$";
    private static final int AFM_SIZE = 9;



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotEmpty(message = "{repairCreate.scheduledDate.not.null}")
    private String scheduledDate;

    private StateOfRepair state;

    private TypeOfRepair typeOfRepair;

    @Pattern(regexp = COST_PATTERN, message = "{repairCreate.cost.pattern.invalid}")
    @NotEmpty(message = "{repairCreate.cost.not.null}")
    private String cost;

    @NotEmpty(message = "{repairCreate.address.not.null}")
    private String address;

    private String textDesc;

    private Long id;

    private String ownersName;


    private Property property;


    public RepairModel(String scheduledDate, StateOfRepair state, TypeOfRepair typeOfRepair, String cost, String address, String textDesc, Long id, String ownersName) {
        this.scheduledDate = scheduledDate;
        this.state = state;
        this.typeOfRepair = typeOfRepair;
        this.cost = cost;
        this.address = address;
        this.textDesc = textDesc;
        this.id = id;
        this.ownersName = ownersName;
    }

    public RepairModel() {
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }


    public String getScheduledDate() {
        return scheduledDate;
    }

    public StateOfRepair getState() {
        return state;
    }

    public TypeOfRepair getTypeOfRepair() {
        return typeOfRepair;
    }

    public String getCost() {
        return cost;
    }

    public String getAddress() {
        return address;
    }

    public String getTextDesc() {
        return textDesc;
    }

    public Long getId() {
        return id;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public void setState(StateOfRepair state) {
        this.state = state;
    }

    public void setTypeOfRepair(TypeOfRepair typeOfRepair) {
        this.typeOfRepair = typeOfRepair;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTextDesc(String textDesc) {
        this.textDesc = textDesc;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
