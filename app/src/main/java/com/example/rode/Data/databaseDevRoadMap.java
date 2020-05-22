package com.example.rode.Data;

import com.example.rode.Logic.ArrayToArrayList;

import java.util.ArrayList;

public class databaseDevRoadMap {

    private String[] dbRoad = {"Oracle 12c SQL Programming : Introduction" ,

            "Oracle 12c SQL Programming : Relational Databases & Data Models" ,

            "Oracle 12c SQL Programming : Selection & Setup of the Database Interface" ,

            "Oracle 12c SQL Programming : Using the Database Interface" ,

            "Oracle 12c SQL Programming : Sorting Data with the Order By Clause",

            "Oracle 12c SQL Programming : Aggregating Data Within Groups" ,

            "Oracle 12c SQL Programming : Use DDL to Create & Manage Tables" ,

            "Oracle 12c SQL Programming : Enhancing Groups with Rollup & Cube " ,

            "Oracle 12c SQL Programming : SQL Functions: Character Handling & Numeric Handling & Date Handling " ,

            "Oracle 12c SQL Programming : Database Objects: Relational Views & Indexes & Creating Other Objects & Security & Object Management Using DDL " ,

            "Oracle 12c SQL Programming : Data Integrity Using Constraints ",

            "Oracle 12c SQL Programming : Managing Constraint Definitions " ,

            "Oracle 12c SQL Programming : The Data Dictionary Structure "
            ,"Oracle 12c SQL Programming : Conclusion " ,

            "Oracle 12c PL/SQL Programming : Introduction" ,

            "Oracle 12c PL/SQL Programming : Bind & Substitution Variables" ,

            "Oracle 12c PL/SQL Programming : PL/SQL Language Fundamentals" ,

            "Oracle 12c PL/SQL Programming : Declare , Begin , Exception Section" ,

            "Oracle 12c PL/SQL Programming : Creating Stored Procedures & Functions" ,

            "Oracle 12c PL/SQL Programming : Executing Stored Procedures & Functions" ,

            "Oracle 12c PL/SQL Programming : Maintaining Stored Program Units" ,

            "Oracle 12c PL/SQL Programming : Creating & Maintaining Packages" ,

            "Oracle 12c PL/SQL Programming : Advanced Package Capabilities & Advanced Cursor Techniques" ,

            "Oracle 12c PL/SQL Programming : Using System-Supplied Packages" ,

            "Oracle 12c PL/SQL Programming : Database Trigger Concepts" ,

            "Oracle 12c PL/SQL Programming : Creating Database Triggers" ,

            "Oracle 12c PL/SQL Programming : Maintaining Database Triggers" ,

            "Oracle 12c PL/SQL Programming : Conclusion" ,

            "Oracle 12c PL/SQL Programming : Beyond The Basics: Explicit Cursors" ,
            "Oracle Database 12c PL/SQL Advanced Programming & Tuning : Introduction" ,

            "Oracle Database 12c PL/SQL Advanced Programming & Tuning : Why Needed & PL/SQL Execution Internals" ,

            "Oracle Database 12c PL/SQL Advanced Programming & Tuning : Dynamic SQL & Java & C Interface Methods" ,

            "Oracle Database 12c PL/SQL Advanced Programming & Tuning : System-Supplied Packages: DBMS_METADATA() – Part I & Part ll & Part lll " ,

            "Oracle Database 12c PL/SQL Advanced Programming & Tuning : System-Supplied Packages: DBMS_REDEFINITION() & DBMS_LOB()" ,

            "Oracle Database 12c PL/SQL Advanced Programming & Tuning : High-Performance: Advanced System-Supplied Packages & Programming & Coding Techniques & Influencing Oracle PL/ SQL Compilation  " ,

            "Oracle Database 12c PL/SQL Advanced Programming & Tuning : High Performance: Dynamic Partitioning & Parallelization & Using PL/Scope For Code Analysis" ,

            "Oracle Database 12c PL/SQL Advanced Programming & Tuning : Application Security: SQL Injection Attacks & Virtual Private Databases" ,

            "Oracle Database 12c PL/SQL Advanced Programming & Tuning : Conclusion"};

    public ArrayList<String> getDbRoad() {
        ArrayToArrayList obj = new ArrayToArrayList();

        return obj.convertArray(dbRoad);
    }

   public String Resourses = "https://www.accelebrate.com/oracle-training";
}
