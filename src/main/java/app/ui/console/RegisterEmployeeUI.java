package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.shared.Constants;
import app.ui.console.utils.Generators;
import app.ui.console.utils.Utils;

/**
 * The type Register employee ui.
 */
public class RegisterEmployeeUI implements Runnable{

    /**
     * Controller used to specify a new employee.
     */
    private RegisterEmployeeController ctrl ;

    /**
     * Instantiates a new Register employee ui.
     */
    public RegisterEmployeeUI(){
        ctrl= new RegisterEmployeeController();
    }

    /**
     * Runnable that is used to activate the UI.
     */

    public void run() {

        String role;
        System.out.println("\n1: Receptionist\n2: Center Coordinator\n3: Nurse\n");
        int optRole = Utils.readIntegerFromConsole("Whats The Option?");

        try{
            switch(optRole) {
                case 1:
                    role = Constants.ROLE_RECEPTIONIST;
                    break;
                case 2:
                    role = Constants.ROLE_CENTER_COORDINATOR;
                    break;
                case 3:
                    role = Constants.ROLE_NURSE;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Role");
            }


            if(ctrl.createEmployee(askName(), askEmail(),askAddress(),askPhoneNumber(),askCitizenCard(), role, generateEmployeeID())){

                System.out.println(ctrl.showEmployee());

                String opt= SaveOrNot();

                if(opt.equalsIgnoreCase("yes")){
                    if(ctrl.saveEmployee()){
                        System.out.println("\nEmployee added successfully!\n");
                    }else{
                        System.out.println("\nEmployee not added since it already is registered on the system.\n");
                    }
                }else if(opt.equalsIgnoreCase("no")){
                    System.out.println("Employee Type not saved");
                }else{
                    System.out.println("\nInvalid option\nEmployee not saved");
                }
            }else{
                System.out.println("\nEmployee not saved since it already exists or data is invalid\n");
            }
        }catch(NumberFormatException nfe){
            System.out.println("Invalid Role");
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }

    /**
     * Asks name.
     *
     * @return name string
     */
    public String askName(){
        return Utils.readLineFromConsole("Name?");
    }

    /**
     * Asks email.
     *
     * @return email string
     */
    public String askEmail(){return Utils.readLineFromConsole("E-mail: ");}

    /**
     * Asks adress.
     *
     * @return adress string
     */
    public String askAddress(){return Utils.readLineFromConsole("Address: ");}

    /**
     * Asks phonenumber.
     *
     * @return phonenumber string
     */
    public String askPhoneNumber(){return Utils.readLineFromConsole("Phone Number: ");}

    /**
     * Asks citizen card number.
     *
     * @return citizen card number
     */
    public String askCitizenCard(){return Utils.readLineFromConsole("Citizen Card Number: ");}

    /**
     * Save or not data.
     *
     * @return yes, no or error
     */
    public String SaveOrNot(){
        String opt;
        opt = Utils.readLineFromConsole("Register Employee (yes/no)");
        if(opt.equalsIgnoreCase("yes") || opt.equalsIgnoreCase("no")){
            return opt;
        }else{
            return "error";
        }

    }

    /**
     * Generates a random employee ID.
     *
     * @return random employee ID
     */
    public String generateEmployeeID(){
        return Generators.generateEmployeeID();
    }

}
