package H2Database.functionality;

import java.io.IOException;
import java.util.logging.*;

public class Logging {
    private final static Logger logger = Logger.getLogger("Logging");

    public static Logger getLogger(){
        LogManager.getLogManager().reset();
        logger.setLevel(Level.CONFIG);

        try{
            FileHandler fileHandler = new FileHandler("logger.log", false);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
        }catch (IOException ioException){
            logger.log(Level.SEVERE,"File Logger Failed", ioException);
        }
        return logger;
    }
}
