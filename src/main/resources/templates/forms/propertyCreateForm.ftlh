<#import "/spring.ftl" as spring />

<h3 class="mb-3">
            <span style="font-size: 1em; color: #E63946;">
            <i class="fas fa-plus-circle"></i>
            </span></i> Add Property</h3>

<form id="createForm" action="/admin/property/create" name="propertyCreateForm" method="post">

    <div class="row">
        <#if propertyTypes??>

            <div class="form-group col-md-6 text-left">
                <label for="typeOfProperty">Type of property*</label>
                <div class="input-group">
                    <select class="custom-select d-block w-100" id="typeOfproperty" name="typeOfProperty">

                        <#list propertyTypes as type>
                            <option value="${type}"> ${type}</option>
                        </#list>

                    </select>
                </div>
            </div>

        </#if>

        <#--    </div>-->
        <div class="form-group col-md-6 text-left">
            <label for="cost">Property Identity*</label>
            <div class="input-group">
                <@spring.bind "createPropertyForm.propertyE9"/>
                <input type="text" class="form-control" id="propertyE9"  name="propertyE9" value="${createPropertyForm.propertyE9!''}" required>

            </div>
            <#if spring.status.error>
                <ul>
                    <#list spring.status.errorMessages as error>
                        <li style="color: #dc3545">${error}</li>
                    </#list>
                </ul>
            </#if>
        </div>
    </div>


    <div class="row">
        <div class="form-group col-md-6 text-left">
            <label for="address">Address*</label>
            <div class="input-group">
                <@spring.bind "createPropertyForm.address"/>
                <input type="text" class="form-control" id="title" name="address" value="${createPropertyForm.address!''}" required>

            </div>
            <#if spring.status.error>
                <ul>
                    <#list spring.status.errorMessages as error>
                        <li style="color: #dc3545">${error}</li>
                    </#list>
                </ul>
            </#if>
        </div>

        <div class="form-group col-md-6 text-left">
            <label for="textDesc">Year*</label>
            <div class="input-group">
                <@spring.bind "createPropertyForm.year"/>
                <input type="text" class="form-control" id="year" name="year" value="${createPropertyForm.year!''}" required>
            </div>
            <#if spring.status.error>
                <ul>
                    <#list spring.status.errorMessages as error>
                        <li style="color: #dc3545">${error}</li>
                    </#list>
                </ul>
            </#if>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-6 text-left">
            <label for="ownersAfm">Owner's AFM*</label>
            <div class="input-group">
                <@spring.bind "createPropertyForm.afm"/>
                <input type="text" class="form-control" id="afm"
                       name="afm" value="${createPropertyForm.afm!''}" required>

            </div>
            <#if spring.status.error>
                <ul>
                    <#list spring.status.errorMessages as error>
                        <li style="color: #dc3545">${error}</li>
                    </#list>
                </ul>
            </#if>
        </div>
        <div class="form-group col-md-6 text-right">
            <small> *Required Fields</small>
        </div>
    </div>
    <button class="btn btn-lg mt-4 btnblue" type="submit">Create</button>
</form>