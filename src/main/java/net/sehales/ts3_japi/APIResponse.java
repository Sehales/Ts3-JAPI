package net.sehales.ts3_japi;

import net.sehales.ts3_japi.command.ArrayResponseCommand;
import net.sehales.ts3_japi.command.Command;
import net.sehales.ts3_japi.wrapper.QueryError;

/**
 * 
 * @author Sehales
 *
 * @param <C>
 *            the command class
 * @param <W>
 *            the wrapper class
 */
public class APIResponse<C extends Command, W> {

    @FunctionalInterface
    public interface WrapperSupplier<C, W> {
        W get(C cmd);
    }

    private C                     command;
    private WrapperSupplier<C, W> supplier;
    private W                     wrapper;

    APIResponse(C command, WrapperSupplier<C, W> supp) {
        this.command = command;
        supplier = supp;
    }

    /**
     * Always returns a command object. Can't be null.
     * 
     * @return The command that is associated with this response.
     */
    public C getCommand() {
        return command;
    }

    public QueryError getError() {
        return command.getError();
    }

    /**
     * Obtain a response wrapper or null, if there is no response. </br>It will always return the same reference (if it is not null)
     * 
     * @return A response wrapper of type {@link W} if {@link C} is an instance of {@link ArrayResponseCommand}, null otherwise
     */
    public W getWrapper() {
        if (command instanceof ArrayResponseCommand) {
            if (wrapper != null) {
                return wrapper;
            } else {
                return (wrapper = supplier.get(command));
            }
        } else {
            return null;
        }
    }

    /**
     * Returns true if there is any kind of answer (an error id, regardless of the error id)
     * 
     * @return True if the command has been answered, false otherwise
     */
    public boolean isAnswered() {
        return command.isAnswered();
    }

    /**
     * Combines the result of {@link #isAnswered()} and {@link #isOk()}
     * 
     * @return True if {@link #isAnswered()} and {@link #isOk()} return true, false otherwise
     */
    public boolean isAnsweredAndOk() {
        return isAnswered() && isOk();
    }

    /**
     * An error is ok, when the error id equals zero. That means that the command has been executed without any issues.
     * 
     * To get the error id
     * 
     * @return True if the command has been executed without issues, false otherwise
     */
    public boolean isOk() {
        return getError().isOk();
    }
}
