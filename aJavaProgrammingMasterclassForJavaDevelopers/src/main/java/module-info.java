module aJavaProgrammingMasterclassForJavaDevelopers {

    requires javafx.media;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires org.junit.jupiter.params;
    requires org.junit.jupiter.engine;
    requires org.junit.jupiter.api;
    requires sqlite.jdbc;
    requires java.sql;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires java.desktop;

    opens kJavaFX.aHelloWorldFX;
    opens kJavaFX.bLayouts;
    opens kJavaFX.cHBoxLayout;
    opens kJavaFX.dBorderPaneLayout;
    opens kJavaFX.eOtherLayouts;
    opens kJavaFX.fControls;
    opens kJavaFX.gEventsAndEventsHandlers;
    opens kJavaFX.hUIThread;
    opens kJavaFX.iToDoListApplication;
    opens kJavaFX.iToDoListApplication.datamodel;
    opens kJavaFX.jJavaFxCss;
    opens kJavaFX.kTransformingNodesAndChoosers;
    opens kJavaFX.lSceneBuilder;
    opens kJavaFX.mJavaFXChallengeContactsApp;
    opens kJavaFX.mJavaFXChallengeContactsApp.datamodel;
    opens mConcurrencyInJava.kJavaFXBackgroundTask.aTask;
    opens mConcurrencyInJava.kJavaFXBackgroundTask.bService;
    opens nLambdaExpressions.bContinuingLambdaExpressions;
    opens rDatabases.hJDBCwithGUI;
    opens rDatabases.hJDBCwithGUI.Model;

    exports kJavaFX.aHelloWorldFX;
    exports kJavaFX.bLayouts;
    exports kJavaFX.cHBoxLayout;
    exports kJavaFX.dBorderPaneLayout;
    exports kJavaFX.eOtherLayouts;
    exports kJavaFX.fControls;
    exports kJavaFX.gEventsAndEventsHandlers;
    exports kJavaFX.hUIThread;
    exports kJavaFX.iToDoListApplication;
    exports kJavaFX.iToDoListApplication.datamodel;
    exports kJavaFX.jJavaFxCss;
    exports kJavaFX.kTransformingNodesAndChoosers;
    exports kJavaFX.lSceneBuilder;
    exports kJavaFX.mJavaFXChallengeContactsApp;
    exports kJavaFX.mJavaFXChallengeContactsApp.datamodel;
    exports mConcurrencyInJava.kJavaFXBackgroundTask.aTask;
    exports mConcurrencyInJava.kJavaFXBackgroundTask.bService;
    exports nLambdaExpressions.bContinuingLambdaExpressions;
    exports qDebuggingAndUnitTesting.aIntroductionToDebugging;
    exports rDatabases.hJDBCwithGUI;
    exports rDatabases.hJDBCwithGUI.Model;

}