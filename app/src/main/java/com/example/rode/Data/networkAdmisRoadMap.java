package com.example.rode.Data;

import com.example.rode.Logic.ArrayToArrayList;

import java.util.ArrayList;

public class networkAdmisRoadMap {

    private String[] networkRoad = { "Cisco : CCENT" , "Cisco : CCNA routing and switching" ,
            "CCNA R&S  : Describe network fundamentals and build simple LANs " ,
            "CCNA R&S : Explain IP addressing and subnetting" ,
            "CCNA R&S : Describe hubs, switches and routers"  ,
            "CCNA R&S : CCNA cloud",
            "CCNA R&S  : CCNA routing and switching",
            "CCNA R&S :Explain the OSI and TCP/IP models",
            "CCNA R&S :Explain how addresses are allocated using DHCP",
            "CCNA R&S : Explain name resolution using DNS",
            "CCNA R&S : Explain Access Control Lists (ACLs)",
            "CCNA R&S  : Explain Wi-Fi 6 and other Wi-Fi technologies",

            "CCNA security : Modern Network Security Threats",
            "CCNA security :Securing Network Devices",
            "CCNA security :Authentication Authorization and Accounting (AAA)",
            "CCNA security :Implementing Firewall Technologies",
            "CCNA security :Implementing Intrusion Prevention",
            "CCNA security :Securing the Local Area Network",
            "CCNA security :Cryptography",
            "CCNA security : Implementing Virtual Private Networks",
            "CCNA security :Managing a Secure Network",

            "CCNA wirless :Describe WLAN fundamentals",
            "CCNA wirless :Install a basic Cisco wireless LAN",
            "CCNA wirless :Install Wireless Clients",
            "CCNA wirless : Implement basic WLAN Security",
            "CCNA wirless :Operate basic WCS",
            "CCNA wirless :Conduct basic WLAN Maintenance and Troubleshooting",

            "CCNA voice : Introduction to the Cisco Unified Communications Architecture",
            "CCNA voice : Operations of Traditional Telephony",
            "CCNA voice : Fundamentals of VoIP, its components and technologies",
            "CCNA voice : Implementation of the Cisco Unified Communications Manager",
            "CCNA voice : Implementation of the Cisco Unity Express",
            "CCNA voice : Implementation of the Cisco Smart Business Communications System",

            "CCNA cloud : Understanding Cisco Cloud Fundamentals (CLDFND)",
            "CCNA cloud :  Cloud Technical Administrators",
            "CCNA cloud : Cloud Infrastructure Architects",
            "CCNA cloud :  Cisco Integrators and Partners",
            "CCNA cloud :provide operation and support of Cisco Cloud Products and Solutions",
            "CCNA cloud :provides students with the necessary knowledge, skills and attitudes (KSA) to perform foundational tasks related to Cloud computing",
            "CCNA cloud :Deploying Cisco Virtual Security Gateway",

            "CCNP R&S :  Preparation",
            "CCNP R&S : Routing Fundamentals",
            "CCNP R&S: EIGRP",
            "CCNP R&S: OSPF",
            "CCNP R&S: Redistribution",
            "CCNP R&S: Route Selection",
            "CCNP R&S: BGP (Border Gateway Protocol)",
            "CCNP R&S: IPv6",
            "CCNP R&S: Remote Site Connectivity",
            "CCNP R&S: Router Security and Management",

            "CCNP security :Implementing and Operating Cisco Security Core Technologies",
            "CCNP security : Securing Networks with Cisco Firepower",
            "CCNP security : Implementing and Configuring Cisco Identity Services Engine",
            "CCNP security : Securing Email with Cisco Email Security Appliance",
            "CCNP security : Securing the Web with Cisco Web Security Appliance",
            "CCNP security : Implementing Secure Solutions with Virtual Private Networks",
            "CCNP security : Automating and Programming Cisco Security Solutions",

            "CCNP voice : Cisco Unified Communications Manager (formerly Unified CallManager)",

            "CCNP voice :Cisco Quality of Service (QoS)",
            "CCNP voice :Gateways and Gatekeepers",
            "CCNP voice :IP phones",
            "CCNP voice :Cisco voice applications and utilities",
            "CCNP voice : Cisco Unity Connection and Cisco Unified Presence applications"};

    public ArrayList<String> getNetworkRoad() {
        ArrayToArrayList obj = new ArrayToArrayList();

        return obj.convertArray(networkRoad);
    }
   public String Resources ="https://learningnetwork.cisco.com/s/ccnp-security";
//    "www.learnfly.com/cisco-courses"
//            "https://ine.com/products/ccnp-voice-bootcamp"
//            "https://learningnetwork.cisco.com/s/ccnp-security"
//            "http://www.flane.com/course-offerings/cisco/cisco-cloud-training/ccna-cloud.html"

}
