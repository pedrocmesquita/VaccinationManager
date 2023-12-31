# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._

###Authentication
N/A

###Security
- Only the nurses are allowed to access all user’s health data;
- All those who wish to use the application must be authenticated with a password holding seven alphanumeric characters, including three capital letters and two digits;
###Reporting
- Use Javadoc to generate useful documentation for Java code;

## Scheduling
- When SNS user schedules application should check availability of the chosen center
- The application should check the vaccination center capacity for that day/time and, if possible, confirm that the vaccination is scheduled and inform the user that (s)he should be at the selected vaccination center at the scheduled day and time
- Administrators use the application to register centers, SNS users, center coordinators, receptionists, and nurses enrolled in the vaccination process
- There 2 types of vaccination centers: ARS (Administração Regional de Saúde) and AGES (Agrupamentos de Centros de Saúde);
- Both types of vaccination centers can administer any type of vaccines.
- An Administrator is responsible for properly configuring and managing the core information

## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

- Both kinds of vaccination centers are characterized by a name, an address, a phone number, an e-mail address, a
fax number, a website address, opening and closing hours, slot duration and the maximum number of vaccines that can be given per slot;


- When Sns user goes to get the vaccine the receptionist:
    - Registers the arrival of SNS user
    - Ask SNS User for his number
    - Confirm if sns user has vaccine scheduled for the that day and time
    - If information is correct tells the system user is ready to take vaccine
    - Sends SNS user to waiting room
    - The computational complexity analysis (of the brute-force algorithm and any sorting algorithms implemented within this application), must be accompanied by the observation of the execution time of the algorithms for inputs of variable size, in order to observe the asymptotic
      behavior.
- The worst-case time complexity analysis of the algorithms should be properly documented in the user manual of the application (in the annexes).

##Ease of learning
- The user manual must be delivered with the application



## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

N/A


## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

N/A

## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 

N/A

###Testability
- Unit tests must be implemented for all methods, excluding those that implement Input/Output operations;
- The JaCoCo plugin should be used to generate the coverage report
- The unit tests should be implemented using the JUnit 5 framework
##Localization
- The application must support, at least, the Portuguese and the English languages



## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._


- The application must be developed in Java language using the IntelliJ IDE or NetBeans
- The application graphical interface is to be developed in JavaFX 11
- Users must be authenticated with a password holding seven alphanumeric characters, including three capital letters and two digits
- Types Of Vaccines:
    - Covid-19
    - Dengue
    - Tetanus
    - smallpox

- After vaccination each nurse registers the event in the system with:
  - vaccine type (e.g.: Covid-19) 
  - vaccine name/brand (e.g.: Astra Zeneca, Moderna, Pfizer) 
  - lot number used  
- All the images/figures produced during the software development process should be recorded in SVG format.



### Implementation Constraints

_Specifies or constraints the code or construction of a system such
 as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._


- All the images/figures produced during the software development process should be recorded in SVG format.
- The application should implement a bruteforce algorithm (an algorithm which examines all the contiguous subsequences) to determine the efficiency of the vaccination center during  predetermined period of time;
- The implemented algorithm should be analyzed in terms of its worst-case time complexity, and it should be compared to a benchmark algorithm provided;





### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._


- If the user authorizes the sending of the SMS, the application should send an SMS message when the vaccination event is scheduled and registered in the system
- The system should be able to notify(e.g.: SMS or email) the user that his/her recovery period has ended

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

N/A