package soze.software.industries.eMall;

import java.util.Date;

public class PersistentObject {

	public final Long	version;

	public final Date	created;

	public final User	createdBy;

	public PersistentObject(Long version, Date created, User createdBy) {
		this.version = version;
		this.created = created;
		this.createdBy = createdBy;
	}

	public PersistentObject(User createdBy) {
		this(1L, new Date(), createdBy);
	}

}
