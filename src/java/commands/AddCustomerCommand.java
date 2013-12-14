/*
 */
package commands;


import dto.CustomerDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 * @author Lars Mortensen
 */
public class AddCustomerCommand extends TargetCommand {

    public AddCustomerCommand(String target,SecurityRole role) {
        super(target,role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String firstname = request.getParameter("firstname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String lastname = request.getParameter("lastname");
        String mail = request.getParameter("mail");
        Integer phone = Integer.parseInt(request.getParameter("phone"));
        String address = request.getParameter("address");
        if (!firstname.isEmpty() && !username.isEmpty() && !password.isEmpty() && !lastname.isEmpty() && !mail.isEmpty()) {
            Factory.getInstance().getBankManager().addCustomer(new CustomerDTO(firstname,lastname, address, username, password, phone, mail));
            String created = "Customer Created";
            request.setAttribute("created", created);
            Command command = servlets.Factory.getInstance().getCommand("listcustomer",request);
            String path = command.execute(request);
            return path;
        } else {
            String error = "Culd not create customer please insert data in all fields.";
            request.setAttribute("errorincreating", error);
            Command command = servlets.Factory.getInstance().getCommand("gotoaddcustomer",request);
            String path = command.execute(request);
            return path;
        }
        // return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
}
