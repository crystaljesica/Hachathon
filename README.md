# Hachathon
aims to help local food bank rearrange the locations to help more to vulnerable groups

## Background - Start from the people in need
Many vulnerable groups in BC can not get food safely. Some older people may need food delivery, and pregnant women may also need to come to some food hubs near their homes.
Our group aims to help those people find the most convenient food hubs by calculating the optimal distance between the hubs and their homes. To make them have a better life.

## Mocks



## 3 Steps of the algorithm
1.Demand in the area - How many potential needs in the area 
  a.Default : Lone Parent,  Low Income, Elder
  b.User Defined : can add or select other cols 
  
2.Existing Hubs - Is the number of existing hubs enough 
  a.Surrounding Food Hubs Qty / Demand in Area = Coverage Rate
  
3.New Hubs Location - Find the recommended location
  a.Easier Access - Closer to Major Transportation
  b.Lower Logistic costs - Closer to Supplier 
  c.Lower Settle Down costs - Potential Partnership Site  
  
  
 ## 4 Demand in the area
 Demand Score (Demand in need) =
w1* children Factor(%)  + w2 * Elder Factor(%)  + w3 * Lone Parent Family Households(%) 
+ w4 * Low income households (%) + w5 * Household 25-64 Education No Certificate Diploma Degree(%) 
+ w5*Household Pop Age 15 + w6*Unemployed(%) + w7*Household Population for Visible Minority(%) 
+ w8*Household Population Immigrant(%) + w9*1 Person Household (%)


## 5 Coverage Rate
1.Compare the existing hubs with total demand in the map (Geoapify, Haversine)
2.Categorize the area based on coverage rate:
  Top Urgency : High Demand - Low / No Coverage
  Middle Urgency : Medium Demand - Low / No Coverage
  Low Urgency: High Coverage 
3.Highlight the Top Urgent Area and recommend new food hubs location in the area


## 6 technology
Backend
MySQLdatabase: We created a locations table on a mysql database with 4 relevant columns namely; Address, latitude, longitude and relationship. The relationship tells us if a location is a partner, a producer, a distributor or an existing hub.

Java (Spring framework): We used Haversine function to calculate the spherical distance from one point to another on the earth’s surface. That way, we can find out the nearest producer, distrubutor, existing hub and partner within a given radius from a prospective location. An end point is then exposed to our front end.

Frontend
React
Google Maps API





