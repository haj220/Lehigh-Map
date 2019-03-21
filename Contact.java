
/**
 * @author parkerjiang
 * @version 2018.04.27
 */
@SuppressWarnings("rawtypes")
public class Contact implements Comparable<Contact> {
    /**
     * lol
     */
    private String last;
    /**
     * lol
     */
    private String first;
    /**
     * lol
     */
    private String number;

    /**
     * @param last
     *            last name
     * @param first
     *            first name
     * @param number
     *            phone number
     */
    public Contact(String last, String first, String number) {
        this.first = first;
        this.last = last;
        this.number = number;
    }

    @Override
    public int compareTo(Contact o) {
        if (this.last.equals(o.last)) {
            if (this.first.equals(o.first)) {
                if (this.number.equals(o.number)) {
                    return 0;
                }
            }
        }

        return 1;
    }

}
