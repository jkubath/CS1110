/* CLASS:  Song          USED BY MyTunes PROJECT
 * AUTHOR:         Jonah Kubath            DESIGNER: Kaminski
 * DESCRIPTION:  This class does all handling of a SINGLE Song.
 *      It does NOT know that eventually there will be many songs.
 * NOTE:  constructor does basic "dirty data" cleanup.
 *        The individual setters do the:
 *          - data type conversions (from Strings to ...), if needed
 *          - editing for validity-checking (legal/reasonableness checking)
 *          - changing bad data into devault values.        
 *****************************************************************************/
package mytunes;

public class Song {

    //--------------------------------------------------- "GLOBAL" DECLARATIONS
    private final int OLDEST_YEAR = 1950;
    private final int THIS_YEAR = 2016;
    //------------------------------------------------------ INSTANCE VARIABLES
    private String title;
    private String artist;
    private int year;
    private int rating;
    private char genre;
    private double size;
    private int minutes;
    private int seconds;
    private boolean ownIt;

    //---------------------------------------------------------- SETTER METHODS
    // DataType conversions, editing & default value substitutions are needed
    //      on SOME FIELDS.  Assume it's just a simple assignment, e.g.,
    //      title = pTitle;     if no constraints specified below.
    // YEAR - String input is 4 digits, 2016, but only store right 2 digits: 16
    //      - it must be between oldest year & this year (inclusive),
    //          if not, change it to this year
    // RATING - must be a valid integer between 0 & 5 (inclusive),
    //          if not, change it to 0
    // GENRE - valid genre's:  R, F, C, N, W, M, A, E,
    //          if not, change it to default O (for Other)
    //          [NOTE:  a switch statement for this?]
    // SIZE (in MB) - reasonable range: 0.2 to 50.0 (200 KB to 50 MB) inclusive,
    //          if not, change it to a 0.2 
    // MINUTES - reasonable range:  0-20 (inclusive) - if not, change it to 1
    // SECONDS - valid range:  0-59 (inclusive) - if not, change it to 0
    //-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
    private void setTitle(String pTitle) {
        title = pTitle;
    }

    private void setArtist(String pArtist) {
        artist = pArtist;

    }

    private void setYear(String pYear) {
        
        int tYear = Integer.parseInt(pYear);
        if(tYear >= OLDEST_YEAR && tYear <= THIS_YEAR)
        {
            year = tYear % 100; 
        }
        else
            year = THIS_YEAR % 100;
    }
        

    private void setRating(String pRating) {
        int tRating = Integer.parseInt(pRating);
        if (tRating <= 5 && tRating >= 0) {
            rating = tRating;
        } else {
            rating = 0;
        }

    }

    private void setGenre(String pGenre) {
        switch (pGenre) {
            // GENRE - valid genre's:  R, F, C, N, W, M, A, E,
            case ("R"):
                genre = 'R';
                break;
            case ("F"):
                genre = 'F';
                break;
            case ("C"):
                genre = 'C';
                break;
            case ("N"):
                genre = 'N';
                break;
            case ("W"):
                genre = 'W';
                break;
            case ("M"):
                genre = 'M';
                break;
            case ("A"):
                genre = 'A';
                break;
            case ("E"):
                genre = 'E';
                break;
            default:
                genre = 'O';
                break;
        }
    }

    private void setSize(String pSize) {
        // SIZE (in MB) - reasonable range: 0.2 to 50.0 (200 KB to 50 MB) inclusive,
        //          if not, change it to a 0.2 
        double tSize = Double.parseDouble(pSize);
        pSize = String.format("%.1f", tSize);
        tSize = Double.parseDouble(pSize);
        if (tSize <= 50.0 && tSize >= 0.2) {
            size = tSize;
        } else {
            size = 0.2;
        }

    }

    private void setMinutes(String pMinutes) {
        // MINUTES - reasonable range:  0-20 (inclusive) - if not, change it to 1
        int tMinutes = Integer.parseInt(pMinutes);
        if (tMinutes <= 20 && tMinutes >= 0) {
            minutes = tMinutes;
        } else {
            minutes = 1;
        }

    }

    private void setSeconds(String pSeconds) {
        // SECONDS - valid range:  0-59 (inclusive) - if not, change it to 0
        int tSeconds = Integer.parseInt(pSeconds);
        if (tSeconds <= 59 && tSeconds >= 0) {
            seconds = tSeconds;
        } else {
            seconds = 0;
        }
    }

    private void setOwnIt(String pOwnIt) {
        pOwnIt = pOwnIt.toUpperCase();
        char tOwn = pOwnIt.charAt(0);
        if (tOwn == 'Y' || tOwn == 'T' || tOwn == 'S') {
            ownIt = true;
        } else {
            ownIt = false;
        }
    }

    //---------------------------------------------------------- GETTER METHODS
    // Most attributes don't need a getter because the main program only
    //      accesses the data via the toString method to see the object's values.
    // But toString Mmethod needs getters for fields that need some work done on
    //      them - the toString method itself does NOT do any transformation 
    //      work.  So only write getters where needed by toString.
    // YEAR stored as 2-digits, but toString wants a 4-digit year.
    //      Getter adds either 20 or 19 in front of the 2-digit year.  Assume:
    //          - a 2-digit year <= THIS_YEAR - 2000 --->>> use 20 on front
    //          - otherwise                          --->>> use 19 on front
    // TIME stored as TWO fields, but toString wants a single String.
    //      Getter combines minutes & seconds with a : between - like 9:32
    // GENRE stored as a single char, but toString wants a whole word.
    //      Getter uses a switch on genre to determine the word (a String):
    //          Rock, Folk, Classic, NewAge, World, Movie, Alt, EasyLis, Other
    // RATING stored as an int, but toString wants that number of *'s instead.
    //      Getter returns a String of size 5, with the appropriate number of
    //      *'s on the left, space-padded on right (or "none " for 0) based on
    //      the rating int.  [A switch statment]
    // OWNIT stored as a boolean (true/false), but toString wants a Yes or No.
    //      Getter returns a String for this.
    //-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
    private int getYear() {
        int pYear = THIS_YEAR % 100;
        String sYear;
        if (year >= 00 && year <= pYear) {
            if(year >= 0 && year < 10){
                sYear = "200" + year;
            }
            else
                sYear = "20" + year;
        } else {
            sYear = "19" + year;
        }

        pYear = Integer.parseInt(sYear);

        return pYear;
    }

    private String getTime() {
        String tMinutes = String.format("%d:%d", minutes, seconds);

        return tMinutes;         // A TEMPORARY DUMMY VALUE TO MAKE CODE COMPILE
    }

    private String getGenre() {
        //      Getter uses a switch on genre to determine the word (a String):
        //          Rock, Folk, Classic, NewAge, World, Movie, Alt, EasyLis, Other
        String pGenre;
        switch (genre) {
            case ('R'):
                pGenre = "Rock";
                break;
            case ('F'):
                pGenre = "Folk";
                break;
            case ('C'):
                pGenre = "Classic";
                break;
            case ('N'):
                pGenre = "NewAge";
                break;
            case ('W'):
                pGenre = "World";
                break;
            case ('M'):
                pGenre = "Movie";
                break;
            case ('A'):
                pGenre = "Alt";
                break;
            case ('E'):
                pGenre = "EasyLis";
                break;
            case ('O'):
                pGenre = "Other";
                break;
            default:
                pGenre = "None";

        }

        return pGenre;
    }

    private String getRatingStars() {
        String star;
        switch (rating) {
            case (0):
                star = "None ";
                break;
            case (1):
                star = "*    ";
                break;
            case (2):
                star = "**   ";
                break;
            case (3):
                star = "***  ";
                break;
            case (4):
                star = "**** ";
                break;
            case (5):
                star = "*****";
                break;
            default:
                star = "None ";
        }

        return star;         // A TEMPORARY DUMMY VALUE TO MAKE CODE COMPILE
    }

    private String getOwnIt() {
        String own;
        if (ownIt) {
            own = "Yes";
        } else {
            own = "No";
        }

        return own;         // A TEMPORARY DUMMY VALUE TO MAKE CODE COMPILE
    }

    //------------------------------------------------------ CONSTRUCTOR METHOD
    // Constructor's caller sends in a csv line (containing the 9 fields).
    // This line & fields are "cleaned up" a bit by the constructor.
    // Individual fields (all strings) are passed to the 9 setters for further
    //      editing there in the setter.
    //-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
    public Song(String aLine) {
        String[] field = new String[9];
        aLine = aLine.replace("\"", "");
        field = aLine.split(",");
        for (int i = 1; i < field.length; i++) {
            field[i] = field[i].trim();
        }
        setTitle(field[0]);
        setArtist(field[1]);
        setYear(field[2]);
        setRating(field[3]);
        setGenre(field[4]);
        setSize(field[5]);
        setMinutes(field[6]);
        setSeconds(field[7]);
        setOwnIt(field[8]);

    }

    //--------------------------------------------------------- toString METHOD
    // uses String.format to build a SINGLE String containing one song's data
    // For example, input record 1's data would produce this string:
    //Such Great Heights    Iron & Wine ***** 2004  3.9 Rock     4:13 Yes
    // NOTES:
    // - Use example above to count number of columns to specify for each field.
    // - LEFT-justify all fields, except size which must be RIGHT-justified.
    // - Year shows as 4 digits (forced to 4 by the getter, not this method).
    // - Size shows only 1 digit after the decimal point.
    // - getTime, getRating, getGenre, getOwnIt GETTERS determine the correct
    //      results to use here - don't construct those here in toString method.
    @Override
    public String toString() {
        String theSong = "%-21s %-15s %-5s %-4s %6s %-8s %-6s %-3s";
        String formatString = String.format(theSong, title, artist, getRatingStars(),
                getYear(), size, getGenre(), getTime(), getOwnIt());

        return formatString;
    }
    //--------------------------------------------------------- PRIVATE METHODS
    // OPTIONAL, in case a setter/getter/constructor/method needs modularization

}
