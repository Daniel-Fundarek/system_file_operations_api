# system_file_operations_api

This api allows you to use system file operations like create, delete, move and copy directory or file through rest api.

post:
    
    /directory          -- create empty Directory in target directory. 
    /file               -- create empty File in target directory  
    /file/copyfile      -- copy File from one directory to target directory. U can also rename file.
    /file/move          -- move File to target directory. You can also rename file.
    /file/content       -- get content of File
    /file/pattern       -- find files wich contain pattern with line number of occurrence.
    /directory/content  -- get content of Directory. Returns also size of file or directory.
delete:

    /file               -- delete File.
    /directory          -- delete Directory with all files and subfolders in it.
