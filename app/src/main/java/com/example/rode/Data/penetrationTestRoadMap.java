package com.example.rode.Data;

import com.example.rode.Logic.ArrayToArrayList;

import java.util.ArrayList;

public class penetrationTestRoadMap {
    private String[] pTestRoad = {
            "SEC401 Security Essentials: Network Security Essentials",
            "SEC401 Security Essentials: Defense-in-Depth and attacks",
            "SEC401 Security Essentials: Threat managment",
            "SEC401 Security Essentials: Cryptography, Incident Response, and Risk Management",
            "SEC401 Security Essentials: Windows security",
            "SEC401 Security Essentials: Linux Security",
            "SEC504 Hacker Techniques: Incident Handling Step-by-Step and Computer Crime Investigation",
            "SEC504 Hacker Techniques: Computer and Network Hacker Exploits",
            "SEC560 Networks: Comprehensive Pen Test Planning, Scoping, and Recon",
            "SEC560 Networks: In-Depth Scanning",
            "SEC560 Networks: Exploitation",
            "SEC560 Networks: Password Attacks and Merciless Pivoting",
            "SEC560 Networks: Domain Domination and Web App Pen Testing",
            "SEC560 Networks: Penetration Testing Workshop",
            "SEC542 Web apps: Introduction and Information Gathering",
            "SEC542 Web apps: Configuration, Identity, and Authentication Testing",
            "SEC542 Web apps: Injection",
            "SEC542 Web apps: XXE and XSS",
            "SEC542 Web apps: CSRF, Logic Flaws and Advanced Tools",
            "SEC542 Web apps: Capture the Flag",
            "SEC460 Vulnerability Assessment: Methodology, Planning, and Threat Modeling",
            "SEC460 Vulnerability Assessment: Discovery",
            "SEC460 Vulnerability Assessment: Enhanced Vulnerability Scanning and Automation",
            "SEC460 Vulnerability Assessment: Vulnerability Validation, Triage, and Data Management",
            "SEC460 Vulnerability Assessment: Remediation and Reporting",
            "SEC460 Vulnerability Assessment: Vulnerability Assessment Foundry Hands-on Challenge",
            "SEC660 Advanced Penetration Testing: Network Attacks for Penetration Testers",
            "SEC660 Advanced Penetration Testing: Crypto and Post-Exploitation",
            "SEC660 Advanced Penetration Testing: Python, Scapy, and Fuzzing",
            "SEC660 Advanced Penetration Testing: Exploiting Linux for Penetration Testers",
            "SEC660 Advanced Penetration Testing: Exploiting Windows for Penetration Testers",
            "SEC660 Advanced Penetration Testing: Capture the Flag Challenge",
            "SEC642 Advanced Web App Testing: Advanced Attacks",
            "SEC642 Advanced Web App Testing: Web Frameworks",
            "SEC642 Advanced Web App Testing: Web Cryptography",
            "SEC642 Advanced Web App Testing: Alternative Web Interfaces",
            "SEC642 Advanced Web App Testing: Web Application Firewall and Filter Bypass",
            "SEC642 Advanced Web App Testing: Capture the Flag",
            "SEC575 Mobile Device Security: Device Architecture and Application Interaction",
            "SEC575 Mobile Device Security: The Stolen Device Threat and Mobile Malware",
            "SEC575 Mobile Device Security: Static Application Analysis",
            "SEC575 Mobile Device Security: Dynamic Mobile Application Analysis and Manipulation",
            "SEC575 Mobile Device Security: Mobile Penetration Testing",
            "SEC575 Mobile Device Security: Hands-on Capture-the-Flag Event",
            "SEC558 Cloud Penetration Testing: Discovery, Recon, and Architecture at Scale",
            "SEC558 Cloud Penetration Testing: Mapping, Authentication, and Cloud Services",
            "SEC558 Cloud Penetration Testing: Azure and Windows Services in the Cloud",
            "SEC558 Cloud Penetration Testing: Vulnerabilities in Cloud Native Applications",
            "SEC558 Cloud Penetration Testing: Exploitation and Red Team in the Cloud",
            "SEC558 Cloud Penetration Testing: Capstone",
            "SEC617 Wireless Penetration Testing: Wi-Fi Data Collection and Analysis",
            "SEC617 Wireless Penetration Testing: Wi-Fi Attack and Exploitation Techniques",
            "SEC617 Wireless Penetration Testing: Enterprise Wi-Fi, DECT, and Zigbee Attacks",
            "SEC617 Wireless Penetration Testing: Bluetooth and Software Defined Radio Attacks",
            "SEC617 Wireless Penetration Testing: RFID, Smart Cards, and NFC Hacking",
            "SEC617 Wireless Penetration Testing: Hands-on Capture-the-Flag Event",
            "SEC562 Hands-On Ranges: Team Building, Visualizing the Battlespace, Recon, and HMIs",
            "SEC562 Hands-On Ranges: Protocol Manipulation, Data Integrity, and Operator Interface Terminals",
            "SEC562 Hands-On Ranges:  Malware Analysis, Privilege Escalation, Incident Response, Passwords Guessing, and Networking Equipment",
            "SEC562 Hands-On Ranges:  Cryptography and ICS Protocols",
            "SEC562 Hands-On Ranges: Power Grid, Weapons Systems, and Network Manipulation",
            "SEC562 Hands-On Ranges: Force-On-Force Attack and Defend",
            "SEC573 Python for Infosec: Essentials Workshop with pyWars",
            "SEC573 Python for Infosec: Essentials Workshop with MORE pyWars",
            "SEC573 Python for Infosec: Defensive Python",
            "SEC573 Python for Infosec: Forensics Python",
            "SEC573 Python for Infosec: Offensive Python",
            "SEC573 Python for Infosec: Capture-the-Flag Challenge",
            "SEC699 Purple Team Tactics: Adversary Emulation for Breach Prevention & Detection",
            "SEC699 Purple Team Tactics: Advanced Initial Execution Techniques - Threat Actor APT-28",
            "SEC699 Purple Team Tactics: Advanced Active Directory Attacks - Threat Actor APT-34",
            "SEC699 Purple Team Tactics: Stealth Persistence Strategies & Turla",
            "SEC699 Purple Team Tactics: Azure AD Attacks",
            "SEC699 Purple Team Tactics:  Adversary Emulation Capstone"
    };
    String Resources= "https://www.sans.org/cyber-security-skills-roadmap";


    public ArrayList<String> getPTestRoad() {
        ArrayToArrayList obj = new ArrayToArrayList();

        return obj.convertArray(pTestRoad);
    }
}
