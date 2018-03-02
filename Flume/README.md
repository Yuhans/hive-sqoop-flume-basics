### Tasks:
Flume
    - Upload linux_messages_3000lines.txt from [here](linux_messages_3000lines.txt)  
    - Use the following command to create and gradually grow the input:
    ```shell
    cat linux_messages_3000lines.txt | while read line ; do echo "$line" ; sleep 0.2 ; done > output.txt
    ```
    - Write a Flume configuration to upload the ever growing output.txt file to HDFS.
    - Include a screenshot in your report of the output of following command of your output in HDFS:
    ```shell
        hdfs dfs cat ...
    ```

### Solution:
Work consists of 2 shell scripts (flume-start-output.sh, flume-agent.sh) and flume.conf file with config for flume.
You can copy files to your Sandbox, start flume-start-output.sh in background and then start flume-agent.sh