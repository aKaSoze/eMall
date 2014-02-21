package soze.software.industries.eMall;

import java.util.Date;

public class HigherarchyObject extends PersistentObject {

	private static final String	PRINT_OFFSET	= " ";

	public HigherarchyObject(Long version, Date created, User createdBy) {
		super(version, created, createdBy);
	}

	public HigherarchyObject(User createdBy) {
		super(createdBy);
	}

	protected String evaluateOffset(Long level) {
		String offset = "";
		for (Long count = 0L; count < level; count++) {
			offset += PRINT_OFFSET;
		}
		return offset;
	}

	public String toString(Long level) {
		return new StringBuilder().append(evaluateOffset(level)).append(" -> ").append(toString()).toString();
	}

}
