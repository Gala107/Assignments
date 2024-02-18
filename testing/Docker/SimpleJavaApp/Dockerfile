# Let Docker pull the JDK 17 as a Base Image to create our Image
FROM openjdk:17

# Create a Directory by the name MyCashBackApp
# We will copy our code here
RUN mkdir /MyCashBackApp

# Copy the class file i.e. MainClass.class from the bin into the /MyCashBackApp
COPY bin/com /MyCashBackApp

# Set the directory to execute any future commands
WORKDIR /MyCashBackApp

# Execute the java command -> java MainClass
CMD java MainClass