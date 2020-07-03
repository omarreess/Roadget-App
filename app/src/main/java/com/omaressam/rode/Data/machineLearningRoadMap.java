package com.omaressam.rode.Data;

import com.omaressam.rode.Logic.ArrayToArrayList;

import java.util.ArrayList;

public class machineLearningRoadMap {

    public String getResoucre() {
        return Resoucre;
    }

    private String Resoucre = "https://markovdata.com/academy";
    //https://intellipaat.com/machine-learning-certification-training-course/#course-content-section

    private String[] mlRoad = {"Statistics : Introduction" , "Statistics : Sampling Techniques " ,"Statistics :Measures of Central Tendency " ,"Statistics : Measures of Variability " ,"Statistics : Skewness and Outliers "
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
            "Regression : Polynomial Regression" ,
            "Bias and Variance" ,
            "Base Classifiers : Logistics Regression " ,
            "Base Classifiers : Decision Tree-based Methods " ,
            "Base Classifiers : K-Nearest Neighbor " ,
            "Base Classifiers : Neural Networks " ,
            "Base Classifiers : Naive Bayes " ,
            "Base Classifiers : Support Vector Machines" ,
            "Clustering : K-Mean Clustering" ,
            "Clustering : Hierarchical Clustering" ,
            "Clustering : Cluster Evaluation" ,
            "Evaluation of Learning Models : F1-Score" ,
            "Evaluation of Learning Models : Lift Curves" ,
            "Basics of Python" , "Data Structures of Python" ,
            "Fundamentals of Python programming  " , "Libraries of Data Science"
    };


    public ArrayList<String> getMlRoad() {
        ArrayToArrayList obj = new ArrayToArrayList();

        return obj.convertArray(mlRoad);
    }
}
