package VCP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory {

    private final String name;
    private final Directory parentDirectory;
    private final Date dateOfCreation;
    
    private List<Directory> listOfSubDirectory;

    public Directory(String name, Date dateOfCreation, Directory parentDirectory) {
        this.dateOfCreation = dateOfCreation;
        this.name = name;
        this.parentDirectory = parentDirectory;
        this.listOfSubDirectory = new ArrayList<Directory>();

    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public List<Directory> getListOfSubDirectory() {
        return listOfSubDirectory;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateOfCreation == null) ? 0 : dateOfCreation.hashCode());
        result = prime * result + ((listOfSubDirectory == null) ? 0 : listOfSubDirectory.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((parentDirectory == null) ? 0 : parentDirectory.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Directory other = (Directory) obj;
        if (dateOfCreation == null) {
            if (other.dateOfCreation != null)
                return false;
        } else if (!dateOfCreation.equals(other.dateOfCreation))
            return false;
        if (listOfSubDirectory == null) {
            if (other.listOfSubDirectory != null)
                return false;
        } else if (!listOfSubDirectory.equals(other.listOfSubDirectory))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (parentDirectory == null) {
            if (other.parentDirectory != null)
                return false;
        } else if (!parentDirectory.equals(other.parentDirectory))
            return false;
        return true;
    }


}
