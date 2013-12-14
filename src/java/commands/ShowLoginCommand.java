

package commands;

import security.SecurityRole;

  // @author Lars Mortensen
  // This command is necessary because if give us a type to test against
  public class ShowLoginCommand  extends TargetCommand{

  public ShowLoginCommand(String target, SecurityRole role) {
    super(target, role);
  }
}

