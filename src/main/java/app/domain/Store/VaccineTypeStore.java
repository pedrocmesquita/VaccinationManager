package app.domain.Store;

import app.domain.model.VaccineType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccine type store.
 *
 * @author Henrique Pinto - 1211201
 */
public class VaccineTypeStore {

    /**
     * List that will Store VaccineTypes.
     */

    private List<VaccineType> vaccineTypeList;

    /**
     * Declares the vaccine type list as an ArrayList.
     */
    public VaccineTypeStore() {
        this.vaccineTypeList = new ArrayList<>();
    }

    /**
     * Gets vaccine type list.
     *
     * @return vaccineTypeList vaccine type list
     */
    public List<VaccineType> getVaccineTypeList() {
        return vaccineTypeList;
    }

    /**
     * Adds vaccine type to the List.
     *
     * @param vaccineType the vaccine type
     * @return the boolean
     */
    public boolean addVaccineType(VaccineType vaccineType) {
        if(validateVaccineType(vaccineType)) {
            this.vaccineTypeList.add(vaccineType);
            return true;
        }
        return false;
    }

    /**
     * Validates vaccine type boolean.
     *
     * @param vt the vt
     * @return the boolean
     */
    public boolean validateVaccineType (VaccineType vt) {
        if (vt == null) return false;
        return !getVaccineTypeList().contains(vt);
    }

    /**
     * Creates a new VaccineType Object.
     *
     * @param code              the code
     * @param designation       the designation
     * @param vaccineTechnology the vaccine technology
     * @return VaccineType Object
     */
    public VaccineType createVaccineType(String code, String designation, String vaccineTechnology) {
        return new VaccineType(code, designation, vaccineTechnology);
    }

    public void setVaccineTypes(List<VaccineType> readObject) {
        for (VaccineType v : readObject) {
            this.vaccineTypeList.add(v);
        }

        }
}
