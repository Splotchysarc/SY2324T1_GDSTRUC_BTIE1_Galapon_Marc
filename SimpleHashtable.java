public class SimpleHashtable
{
    private StoredStudent[] hashtable;
    private int size; 

    public SimpleHashtable(int capacity)
    {
        hashtable = new StoredStudent[capacity];
        size = 0;
    }

    private int hashKey(String key)
    {
        int hashCode = key.hashCode();
        return (hashCode < 0 ? -hashCode : hashCode) % hashtable.length;
    }

    public void put(String key, Student value)
    {
        if (size >= hashtable.length * 0.7)
        {
            resizeHashtable();
        }

        int hashedKey = hashKey(key);
        int stoppingIndex = hashedKey;

        while (isOccupied(hashedKey)) {
            if (hashedKey == stoppingIndex)
            {
                System.out.println("Hashtable is full.");
                return;
            }
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        hashtable[hashedKey] = new StoredStudent(key, value);
        size++;
    }

    public Student get(String key)
    {
        int hashedKey = findKey(key);
        if (hashedKey == -1)
        {
            return null;
        }
        return hashtable[hashedKey].value;
    }

    public Student remove(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            return null;
        }

        Student removedElement = hashtable[hashedKey].value;

        hashtable[hashedKey] = null;
        size--;

        rehashAfterRemoval();

        return removedElement;
    }

    private void rehashAfterRemoval()
    {
        int newCapacity = hashtable.length;
        StoredStudent[] newHashtable = new StoredStudent[newCapacity];

        for (StoredStudent storedStudent : hashtable)
        {
            if (storedStudent != null)
            {
                int newHashedKey = hashKey(storedStudent.key);
                while (newHashtable[newHashedKey] != null)
                {
                    newHashedKey = (newHashedKey + 1) % newCapacity;
                }
                newHashtable[newHashedKey] = storedStudent;
            }
        }

        hashtable = newHashtable;
    }

    public void printHashtable()
    {
        for (int i = 0; i < hashtable.length; i++)
        {
            if (hashtable[i] != null)
            {
                System.out.println("Element " + i + ": " + hashtable[i]);
            } else
            {
                System.out.println("Element " + i + ": null");
            }
        }
    }

    private boolean isOccupied(int index)
    {
        return index >= 0 && index < hashtable.length && hashtable[index] != null;
    }

    private int findKey(String key)
    {
        int hashedKey = hashKey(key);
        int stoppingIndex = hashedKey;

        while (hashedKey != stoppingIndex)
        {
            if (isSameKey(hashedKey, key))
            {
                return hashedKey;
            }
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        return -1;
    }

    private boolean isSameKey(int hashedKey, String key)
    {
        if (hashtable[hashedKey] != null)
        {
            return hashtable[hashedKey].key.equals(key);
        }
        return false;
    }

    private void resizeHashtable()
    {
        int newCapacity = hashtable.length * 2;
        StoredStudent[] newHashtable = new StoredStudent[newCapacity];

        for (StoredStudent storedStudent : hashtable)
        {
            if (storedStudent != null)
            {
                int newHashedKey = hashKey(storedStudent.key);
                while (newHashtable[newHashedKey] != null)
                {
                    newHashedKey = (newHashedKey + 1) % newCapacity;
                }
                newHashtable[newHashedKey] = storedStudent;
            }
        }

        hashtable = newHashtable;
    }
}
