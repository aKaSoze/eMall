package soze.software.industries.eMall;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HigherarchyObject extends PersistentObject {

	private static final String				PRINT_OFFSET	= "  ";

	protected final Set<HigherarchyObject>	parents			= new HashSet<>(1);
	protected final Set<HigherarchyObject>	childs			= new HashSet<>(7);

	public HigherarchyObject(Long version, Date created, User createdBy) {
		super(version, created, createdBy);
	}

	public HigherarchyObject(User createdBy) {
		super(createdBy);
	}

	public String toString(Long level) {
		String offset = "";
		for (Long count = 0L; count < level; count++) {
			offset += PRINT_OFFSET;
		}
		StringBuilder toStringBuilder = new StringBuilder().append(offset).append(" - ").append(toString());

		if (!childs.isEmpty()) {
			toStringBuilder.append(offset).append("\n|");
			toStringBuilder.append(offset).append("\n|");
			toStringBuilder.append(offset).append("\n\\");
			level++;
			for (HigherarchyObject child : childs) {
				toStringBuilder.append("\n");
				toStringBuilder.append(child.toString(level));
			}
		}
		return toStringBuilder.toString();
	}

}
