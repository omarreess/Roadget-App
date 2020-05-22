package com.example.rode.Data;

import com.example.rode.Logic.ArrayToArrayList;

import java.util.ArrayList;

public class dataScRoadMap {
    public String getResoucre() {
        return Resoucre;
    }



    private String Resoucre ="https://intellipaat.com/data-scientist-course-training/";
    //https://www.analyticsvidhya.com/blog/2016/01/guide-data-exploration/
    //https://www.classcentral.com/course/data-manipulation-4473
    //https://towardsdatascience.com/10-viz-every-ds-should-know-4e4118f26fc3
    private String[] dataScRoad = {"R Programming : Core Programming Principles " ,
            "R Programming : Fundamentals Of R" ,
            "R Programming : Matrices" ,
            "R Programming : Data Frames" ,
            "Data Exploration : Variable Identification" ,
            "Data Exploration : Univariate Analysis" ,
            "Data Exploration : Bi-variate Analysis" ,
            "Data Exploration : Missing values treatment" ,
            "Data Exploration : Outlier treatment" ,
            "Data Exploration : Variable transformation" ,
            "Data Exploration : Variable creation" ,
            "Data Manipulation : Data Science Context and Concepts" ,
            "Data Manipulation : Relational Databases and the Relational Algebra" ,
            "Data Manipulation : MapReduce and Parallel Dataflow Programming" ,
            "Data Manipulation : NoSQL Systems and Concepts" ,
            "Data Manipulation : Graph Analytics" ,
            "Data visualization : Histograms" ,
            "Data visualization : Bar/Pie charts" ,
            "Data visualization : Time series" ,
            "Data visualization : Geo Maps" ,
            "Data visualization : Higher-Dimensional Plots" ,
            "Data visualization : Word clouds" ,
            "Statistics : Introduction" , "Statistics : Sampling Techniques " ,"Statistics :Measures of Central Tendency " ,"Statistics : Measures of Variability " ,"Statistics : Skewness and Outliers "
            , "Probability : Introduction"  , "Probability : Probability Laws", "Probability : Bayesian Theorem", "Probability : Probability Distribution", "Probability : Gaussian Distribution", "Probability : Sampling Distribution"  , "Probability : Central Limit Theorem"
            ,"Normalization : Z-Score ","Normalization : Min-Max Method ","Normalization : Decimal Scaling Method "

            ,"Inferential Statistics :T-Test and Anova " ,"Inferential Statistics :Chi-Square Test ","Inferential Statistics : Spearman Correlation Coefficient ","Inferential Statistics : Pearson Correlation Coefficient","Inferential Statistics : Regression Analysis"
            , "Linear Algebra : Review on Matrices" , "Linear Algebra : Operations on Matrices ",
            "Linear Algebra : Eigen Values and Eigen Vectors " ,
            "Intro to Machine Learning & Data Mining" ,
            "Supervised & Unsupervised Learning " ,
            "Types of Data" ,
            "Data Preprocessing" ,
            "Frequent Item Sets" ,
            "Association Rules & Apriori Algorithm" ,
            "Regression : Linear Regression" ,
            "Regression : Polynomial Regression" };


    public ArrayList<String> getDataScRoad() {
        ArrayToArrayList obj = new ArrayToArrayList();

        return obj.convertArray(dataScRoad);
    }
}
