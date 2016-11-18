GroovyCronScheduleRunner

Designed for Logscape Apps, so that a secondary script may be called. 
Takes two arguments.

GroovyCronScheduleRunner(String PROPERTIESFILE, String SECONDARY SCRIPT)

PROPERTIESFILE = Assumed to be in the lib folder, contains the cron rules for when it should fire.
SECONDARYSCRIPT = Assumed to be in the root directory (if you want a different path, use \\ to ensure correctly escaped paths).
This script must be a groovy or java script, not a generic command. 

CRON RULES

The properties file contains 5 properties. Day of week, hour, minute, second and millisecond. 
If you comment it out, all will be deemed valid. 

For example, this will fire weekdays between 7 and 6. 

days=(1..5)
hours=(7..6)
#mins=(0..60)
#secs=(0..60)
#millis=(0..999)