package app.ui.console;

import app.controller.RegisterSNSUserController;
import app.ui.console.utils.Utils;
import java.util.Date;

/**
 * UI used to specify a new SNS user.
 *
 * @author Henrique Pinto - 1211201
 */
public class RegisterSNSUserUI implements Runnable{

    /**
     * Controller used to specify a new SNS user.
     */
    private RegisterSNSUserController ctrl;

    /**
     * Constructor.Used in order to instantiate the controller.
     */
    public RegisterSNSUserUI() {
        ctrl = new RegisterSNSUserController();
    }

    /**
     * Runnable that is used to activate the UI.
     */

    @Override
    public void run() {

        try {
            if (ctrl.createSNSUser(askname(), askaddress(), askgenderoption(), askPhoneNumber(), askEmail(), askBirthDate(), askSNSNumber(), askCCNumber())) {

                System.out.println(ctrl.showSNSUser());

                String opt = SaveOrNot();

                if(opt.equalsIgnoreCase("yes")){

                    if(ctrl.saveSNSUser()){
                        System.out.println("SNS User saved successfully!");
                    }else{
                        System.out.println("SNS User not saved since it has repeated parameters!");
                    }

                }else if(opt.equalsIgnoreCase("no")){
                    System.out.println("SNS User not saved");
                }else{
                    System.out.println("\nInvalid option\nSNS User not saved");
                }

            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }



    }

    /**
     * Asks name.
     *
     * @return name string
     */
    public String askname(){
        return Utils.readLineFromConsole("Enter the name of the user: ");
    }

    /**
     * Asks address.
     *
     * @return address string
     */
    public String askaddress(){
        return Utils.readLineFromConsole("Enter the address of the user: ");
    }

    /**
     * Asks gender.
     *
     * @return gender string
     */
    public String askgenderoption() {
        return Utils.readLineFromConsole("Insert Gender(Male/Female/Non-Binary/None): ");
    }

    /**
     * Ask phoneNumber.
     *
     * @return phoneNumber string
     */
    public String askPhoneNumber(){
        return Utils.readLineFromConsole("Enter the phone number of the user: ");
    }

    /**
     * Ask email.
     *
     * @return email string
     */
    public String askEmail(){
        return Utils.readLineFromConsole("Enter the email of the user: ");
    }

    /**
     * Ask birthDate.
     *
     * @return birthDate date
     */
    public Date askBirthDate(){
        try {
            return Utils.readDateFromConsole("Enter the birth date of the user: ");
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Asks SNSNumber.
     *
     * @return SNSNumber string
     */
    public String askSNSNumber(){
        return Utils.readLineFromConsole("Enter the SNS number of the user: ");
    }

    /**
     * Ask cc number.
     *
     * @return citizenCardNumber string
     */
    public String askCCNumber(){
        return Utils.readLineFromConsole("Enter the citizen card number of the user: ");
    }

    /**
     * Save or not data.
     *
     * @return yes, no or error
     */
    public String SaveOrNot(){

        String opt;
        opt = Utils.readLineFromConsole("Save SNS User? (yes/no)");
        if(opt.equalsIgnoreCase("yes") || opt.equalsIgnoreCase("no")){
            return opt;
        }else{
            return "error";
        }

    }
}
