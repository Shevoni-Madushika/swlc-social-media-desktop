# CPU5007_OOM
# First Semester

## **Prerequisites**

Please install the following to ensure the development environment

Java Development Kit (JDK) (version 11)

Maven for dependency management

An Integrated Development Environment (IDE) like IntelliJ IDEA

JavaFX SDK - Version: 19.0.2


## **How to Configure JavaFX**

Step-by-Step Guide


01.Copy the following command and save it in your notepad:


--module-path "replace path" --add-modules javafx.controls,javafx.fxml


02.Open the folder where your JavaFX SDK is stored.


03.Right-click on the lib folder inside the SDK directory and copy its path.


04.Replace "replace path" with your lib folder path:


Example updated path:

--module-path "C:\FX\openjfx-19.0.2.1_windows-x64_bin-sdk\javafx-sdk-19.0.2.1\lib" --add-modules javafx.controls,javafx.fxml


05.Open the "Edit Configuration" tab in IntelliJ IDEA:


06.Click the dropdown next to the application runner in IntelliJ IDEA.


07.Select "Edit Configuration".


08.Click "Modify Options".


09.Select "Add VM Options".


10.Paste your path into the "VM Options" field:


Copy the path saved in your notepad and paste it into the "VM Options" field.

11.Click "Apply" and then "OK".


12.Run your project to ensure the configuration is successful.
