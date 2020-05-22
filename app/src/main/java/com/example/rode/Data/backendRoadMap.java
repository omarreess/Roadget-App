package com.example.rode.Data;

import com.example.rode.Logic.ArrayToArrayList;

import java.util.ArrayList;

public class backendRoadMap {


    private String[] backendRoad ={ "Html:Introduction", "Html:Editor", "Html:Elements","Html:Paragraphs","Html:Styles","Html:Formatting","Html:Comments","Html:Colors","Html:Links","Html:Images","Html:Tables","Html:Lists","Html:Blocks","Html:Classes","Html:Id","Html:Iframes","Html:File paths","Html:Responsive","Html:Symbols","Html:URL Encode",

            "CSS:Introducation","CSS:Syntax","CSS:comments", "CSS:Colors","CSS:Backgrounds","CSS:Borders","CSS:Margins","CSS:padding","CSS:height/width","CSS:Box Model","CSS:outling","CSS:text","CSS:fonts","CSS:icons","CSS:links","CSS:lists","CSS:tables","CSS:Display","CSS:Max-width","CSS:Position","CSS:Overflow","CSS:Float","CSS:inline-block","CSS:Align","CSS:Combinators","CSS:Pseudo-class","CSS:Opacity","CSS:Navigation Bar","CSS:Dropdowns","CSS:Images Gallery","CSS:Forms","CSS:Counters","CSS:Website Layout","CSS:Units","CSS:Rounded Corners","CSS:Border-Images","CSS:Shadwos","CSS:Text-Effects","CSS:Animations","CSS:Button","CSS:Pagination","CSS:User Interface","CSS:Box-Sizing","CSS:Flexbox","CSS:Media Queries",

            "JavaScript:Introducation","JavaScript:Where to","JavaScript:Output","JavaScript:Statements","JavaScript:Syntax","JavaScript:Comments","JavaScript:Variables","JavaScript:Operatiors","JavaScript:Arithmetic","JavaScript:Assigments","JavaScript:Data-Types","JavaScript:Functions","JavaScript:Objects","JavaScript:Events","JavaScript:Strings","JavaScript:Numbers","JavaScript:Array","JavaScript:Dates","JavaScript:Booleans","JavaScript:Comparisons","JavaScript:Conditions","JavaScript:Switch","JavaScript:Loop-For","JavaScript:Break","JavaScript:Bitwise","JavaScript:Errors","JavaScript:Scope","JavaScript:Strict Mode","JavaScript:Classes",

            "PHP:Intro","PHP:Syntax","PHP:Comments","PHP:Variables","PHP:Echo/Print","PHP:Data Types","PHP:Strings","PHP:Numbers","PHP:Math","PHP:Constants","PHP:Operatiors","PHP:If&Else&Elseif","PHP:Switch","PHP:Loops","PHP:Functions","PHP:Arrays","PHP:Form","PHP:Date&Time","PHP:Include","PHP:FileHandling","PHP:Open/Read","PHP:Create/Write","PHP:Cookies","PHP:Sessions","PHP:Filters","PHP:JSON","PHP:OOP",

            "MySQL:Intro","MySQL:Connect","MySQL:CreateDB","MySQL:Create Tables","MySQL:Insert Data","MySQL:GetLastID","MySQL:InsertMultiple","MySQL:Prepared","MySQL:SelectData","MySQL:Where","MySQL:OrderBy","MySQL:DeleteData","MySQL:UpdateData","MySQL:LimitData"

};
    public ArrayList<String> getBackendRoad() {
        ArrayToArrayList obj = new ArrayToArrayList();

        return obj.convertArray(backendRoad);
    }
    //String Resources= "https://www.sans.org/cyber-security-skills-roadmap";
 }
