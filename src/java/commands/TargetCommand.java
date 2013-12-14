/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author hsty
 */
public class TargetCommand implements Command {

    private final String target;
    private final String title;
    private final SecurityRole role;

    public TargetCommand(String target, SecurityRole role) {
        this(target, null, role);
    }

    public SecurityRole getRole() {
        return role;
    }

    public TargetCommand(String target, String title, SecurityRole role) {
        this.target = target;
        this.title = title;
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("title", title);
        return target;
    }

}
