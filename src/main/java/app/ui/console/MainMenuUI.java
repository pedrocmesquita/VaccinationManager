package app.ui.console;

import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Main menu ui.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class MainMenuUI {

    /**
     * Instantiates a new Main menu ui.
     */
    public MainMenuUI()
    {
    }

    /**
     * Run.
     *
     * @throws IOException the io exception
     */
    public void run() throws IOException
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Do Login", new AuthUI()));
        options.add(new MenuItem("Know the Development Team",new DevTeamUI()));
        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }


}
