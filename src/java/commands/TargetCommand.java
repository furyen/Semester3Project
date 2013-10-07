/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hsty
 */
public class TargetCommand implements Command {
    
    private final String target;
    private final String title;

    public TargetCommand(String target)
    {
        this(target, null);
    }
    
    public TargetCommand(String target, String title)
    {
        this.target = target;
        this.title = title;
    }
    
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("title", title);
        return target;
    }
    
}
