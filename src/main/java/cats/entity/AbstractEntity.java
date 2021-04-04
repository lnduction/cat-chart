package cats.entity;

import java.io.Serializable;

public abstract class AbstractEntity<T> implements Serializable {
	private static final long serialVersionUID = 8982713310863621560L;
	
	public abstract T getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true;
		} if (obj == null) { return false;
		} if (getClass() != obj.getClass()) { return false; }

		AbstractEntity<T> other = (AbstractEntity<T>) obj;
		if (getId() == null) { return other.getId() == null;
		} else return getId().equals(other.getId());
	}

	@Override
	public String toString() {
		return String.format("%s[id=%s]", getClass().getSimpleName(),  getId());
	}
}
