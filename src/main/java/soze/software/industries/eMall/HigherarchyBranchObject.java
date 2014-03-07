package soze.software.industries.eMall;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HigherarchyBranchObject<ParentType extends HigherarchyBranchObject<?, ?>, ChildType extends HigherarchyObject> extends HigherarchyObject {

    protected final Set<ParentType> parents = new HashSet<>(1);
    protected final Set<ChildType>  childs  = new HashSet<>(7);

    public HigherarchyBranchObject(Long version, Date created, User createdBy) {
        super(version, created, createdBy);
    }

    public HigherarchyBranchObject(User createdBy) {
        super(createdBy);
    }

    public String toString(Long level) {
        StringBuilder toStringBuilder = new StringBuilder(super.toString(level));

        String offset = evaluateOffset(level);
        if (!childs.isEmpty()) {
            toStringBuilder.append("\n").append(offset).append("|");
            toStringBuilder.append("\n").append(offset).append("|");
            toStringBuilder.append("\n").append(offset).append("\\");
            level++;
            for (HigherarchyObject child : childs) {
                toStringBuilder.append("\n");
                toStringBuilder.append(child.toString(level));
            }
        }
        return toStringBuilder.toString();
    }

}
