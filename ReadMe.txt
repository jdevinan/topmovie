Camel Router with Scala DSL Project
===================================
Copy below dataset files from IMDB to the directory "src/main/resources/datasets"
    - name.basics.tsv
    - title.basics.tsv
    - title.crew.tsv
    - title.ratings.tsv

Right Click on MovieApp -> Run MovieApp to execute the program

IMPORTANT NOTE:
----------------
Ideally, should be launched with the script "LaunchOnCluster.sh". And also the below line should be commented in MovieApp file.
    - master("local[*]")

If this line is not commented out, when running on Cluster environment - tasks will not be distributed across the Workers/Executors in the Cluster,
which means the Driver program will in Master Node alone without utilizing the available cluster resources.
It's similar to running in a Single Node Cluster on standalone Laptop setup.


NOTE: Facing some issues with Maven Build tool to build the executable self contained JAR file

OUTPUT
----------
+--------------------+--------------+---------------+-----------------------+------------------+---------------------+---------------------------+
|       Primary Title|Average Rating|Number of Votes|Average Number Of Votes|           Ranking|Primary Credited Name|Primary Credited Profession|
+--------------------+--------------+---------------+-----------------------+------------------+---------------------+---------------------------+
|The Dark Knight R...|           8.4|        1428782|      3043.751712224302| 3943.084040593242|    Christopher Nolan|       writer,producer,d...|
|           Gladiator|           8.5|        1253935|      3043.751712224302| 3501.746695433005|         Ridley Scott|       producer,director...|
|        Interstellar|           8.6|        1358936|      3043.751712224302|3839.6198852433745|    Christopher Nolan|       writer,producer,d...|
|       Batman Begins|           8.2|        1231429|      3043.751712224302| 3317.523489003913|    Christopher Nolan|       writer,producer,d...|
|The Lord of the R...|           8.9|        1545492|      3043.751712224302| 4519.054147799809|        Peter Jackson|       producer,director...|
|           Inception|           8.8|        1904229|      3043.751712224302| 5505.447482033356|    Christopher Nolan|       writer,producer,d...|
|     The Dark Knight|           9.0|        2156317|      3043.751712224302| 6375.964544696036|    Christopher Nolan|       writer,producer,d...|
|          Fight Club|           8.8|        1735367|      3043.751712224302|5017.2389353138615|        David Fincher|       director,producer...|
|               Se7en|           8.6|        1335916|      3043.751712224302| 3774.577786308397|        David Fincher|       director,producer...|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|        Alik Sakharov|       cinematographer,d...|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|       David Petrarca|          director,producer|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|          Jack Bender|       producer,director...|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|          Alex Graves|       producer,director...|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|    Michelle MacLaren|       producer,director...|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|        Neil Marshall|       producer,director...|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|       Daniel Minahan|       director,producer...|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|           Mark Mylod|       director,producer...|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|         David Nutter|          director,producer|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|       Jeremy Podeswa|       director,writer,p...|
|     Game of Thrones|           9.3|        1619110|      3043.751712224302| 4947.093069229411|      Daniel Sackheim|       producer,director...|
+--------------------+--------------+---------------+-----------------------+------------------+---------------------+---------------------------+
only showing top 20 rows
