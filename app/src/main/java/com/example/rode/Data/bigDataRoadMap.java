package com.example.rode.Data;

import com.example.rode.Logic.ArrayToArrayList;

import java.util.ArrayList;

public class bigDataRoadMap {

    public String getResoucre() {
        return Resoucre;
    }

    private String Resoucre = "https://www.clslearn.com/course/big-data-systems-infrastructure/ ";
    private String Resoucre2 ="https://github.com/haifengl/bigdata";

    private String[] bigDataRoad =  {
            "Basic Intro to NoSQL " ,
            "Hadoop Fundamentals : Intro to Hadoop " ,
            "Hadoop Fundamentals : Introduction to MapReduce" ,
            "Hadoop Fundamentals : Intro to YARN" ,
            "Hadoop Fundamentals : Basic Hadoop Cluster Implementation" ,
            "SQL-On-Hadoop : Intro to SQL-On-Hadoop",
            "SQL-On-Hadoop : Intro to Hive",
            "SQL-On-Hadoop : Basic Implementation of Hive & Hive Server 2",
            "SQL-On-Hadoop : Ingesting Data into Hadoop",
            "SQL-On-Hadoop : Intro to Sqoop",
            "SQL-On-Hadoop : Concept of Stream Processing",
            "SQL-On-Hadoop : Into to Kafka",
            "MapReduce In Depth : Hadoop Architecture In Depth",
            "MapReduce In Depth : Intro to Apache Zookeeper",
            "MapReduce In Depth : Advanced Cluster Implementation",
            "Python Programming : Ingesting Data into Hadoop" ,
            "Python Programming : Implementing Kafka Cluster" ,
            "Python Programming : Building Simple Kafka Producer & Consumer Using Python" ,
            "Intro to Apache Spark : Spark Implementation " ,
            "Intro to Apache Spark : Simple Data Analysis with Apache Spark " };


    public ArrayList<String> getBigDataRoad() {
        ArrayToArrayList obj = new ArrayToArrayList();

        return obj.convertArray(bigDataRoad);
    }
}
