package com.example.rode.Data;

import com.example.rode.Logic.ArrayToArrayList;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class frontendRoadMap {
   private String[] frontendRoad = { "Html:Introduction", "Html:Editor", "Html:Elements","Html:Paragraphs","Html:Styles","Html:Formatting","Html:Comments","Html:Colors","Html:Links","Html:Images","Html:Tables","Html:Lists","Html:Blocks","Html:Classes","Html:Id","Html:Iframes","Html:File paths","Html:Responsive","Html:Symbols","Html:URL Encode",

           "CSS:Introducation","CSS:Syntax","CSS:comments", "CSS:Colors","CSS:Backgrounds","CSS:Borders","CSS:Margins","CSS:padding","CSS:height/width","CSS:Box Model","CSS:outling","CSS:text","CSS:fonts","CSS:icons","CSS:links","CSS:lists","CSS:tables","CSS:Display","CSS:Max-width","CSS:Position","CSS:Overflow","CSS:Float","CSS:inline-block","CSS:Align","CSS:Combinators","CSS:Pseudo-class","CSS:Opacity","CSS:Navigation Bar","CSS:Dropdowns","CSS:Images Gallery","CSS:Forms","CSS:Counters","CSS:Website Layout","CSS:Units","CSS:Rounded Corners","CSS:Border-Images","CSS:Shadwos","CSS:Text-Effects","CSS:Animations","CSS:Button" ,"CSS:Pagination","CSS:User Interface","CSS:Box-Sizing","CSS:Flexbox", "CSS:Media Queries",
             "CSS3:Intro","CSS3:News",

            "JavaScript:Introducation","JavaScript:Where to","JavaScript:Output","JavaScript:Statements","JavaScript:Syntax","JavaScript:Comments","JavaScript:Variables","JavaScript:Operatiors","JavaScript:Arithmetic","JavaScript:Assigments","JavaScript:Data-Types","JavaScript:Functions","JavaScript:Objects","JavaScript:Events","JavaScript:Strings","JavaScript:Numbers","JavaScript:Array","JavaScript:Dates","JavaScript:Booleans","JavaScript:Comparisons","JavaScript:Conditions","JavaScript:Switch","JavaScript:Loop-For","JavaScript:Break","JavaScript:Bitwise","JavaScript:Errors","JavaScript:Scope","JavaScript:Strict Mode","JavaScript:Classes",

            "Html5:Intro","Html5:Updates",

            "JQuery:Introducation","JQuery:Syntax","JQuery:Selectors","JQuery:Events","JQuery:Hide/Show","JQuery:Fade","JQuery:Slide","JQuery:Animate","JQuery:Stop()","JQuery:Callback","JQuery:Chaining","JQuery:Get","JQuery:Set","JQuery:Add","JQuery:Remove","JQuery:CSS","JQuery:Traversing","JQuery:Ancestors","JQuery:Descendants","JQuery:Siblings","JQuery:Filtering","JQuery:AjaxIintro","JQuery:Load","JQuery:Get/post","JQuery:NoConflict()","JQuery:Filters",

            "Bootstrap:Intro","Bootstrap:Containers","Bootstrap:Grid Basic","Bootstrap:Typography","Bootstrap:Colors","Bootstrap:Tables","Bootstrap:Images","Bootstrap:Images","Bootstrap:Jumbontron","Bootstrap:Alerts","Bootstrap:Buttons","Bootstrap:Badges","Bootstrap:Progress Bars","Bootstrap:Spinners","Bootstrap:Pagination","Bootstrap:List Groups","Bootstrap:Cards","Bootstrap:Dropdowns","Bootstrap:Collapse","Bootstrap:Navbar","Bootstrap:Forms","Bootstrap:Inputs","Bootstrap:Custom Forms","Bootstrap:Carousel","Bootstrap:Modal","Bootstrap:Toast","Bootstrap:Scrollspy","Bootstrap:Icons","Bootstrap:Filters","Bootstrap:Grid",

            "AngularJS:Introducation","AngularJS:Expression","AngularJS:Modules","AngularJS:Directives","AngularJS:Model","AngularJS:Data Binding","AngularJS:Controllers","AngularJS:Scopes","AngularJS:Filters","AngularJS:Services","AngularJS:Http","AngularJS:Tables","AngularJS:Select","AngularJS:SQL","AngularJS:DOM","AngularJS:Events","AngularJS:Formts","AngularJS:Validation","AngularJS:API","AngularJS:Includes","AngularJS:Animations","AngularJS:Routing","AngularJS:Application"
};

    public ArrayList <String> getFrontendRoad() {
        ArrayToArrayList obj = new ArrayToArrayList();

        return obj.convertArray(frontendRoad);
    }
}
