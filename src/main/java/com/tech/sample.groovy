package com.tech


class sample {

     static void main(String[] args){


          final String books = '''
    <t version-api="2.0">
        <locations>
          <cities>
          <city id = "1">
          <name>chicago</name>
          <number>15</number>
          </city>
           <city id = "2">
          <name>newyork</name>
          <number>12</number>
          </city>
           <city id = "3">
          <name>la</name>
          <number>11</number>
          </city>
           <city id = "4">
          <name>sfo</name>
          <number>5</number>
          </city>
          </cities>
          
       </locations>
    </t>
'''

         def resSlurped = new XmlSlurper().parseText(books)
         def resParsed = new XmlParser().parseText(books)

         assert  resSlurped.locations.cities.city[0].name == 'chicago'
         assert  resParsed.locations.cities.city[0].name.text() == 'chicago'

         //Slurped Xml--sorting based on number so sfo has least number ascending

         def sortSlurpAscening =  resSlurped.locations.cities.city.findAll { it.@id.toInteger() > 0}.sort {it.number}

         println("**** printing slurped ascending order number****  ${ sortSlurpAscening} ")
         assert sortSlurpAscening[0].name == 'sfo'

         //Slurped Xml--sorting based on number so sfo has least number descending

         def sortSlurpDescening =  resSlurped.locations.cities.city.findAll { it.@id.toInteger() > 0}.sort { a,b -> b.number.toInteger() <=>a.number.toInteger() }

         println("**** printing slurped descending order number****  ${ sortSlurpDescening} ")

         assert sortSlurpDescening[0].name == 'chicago'


         //Parsed Xml----sorting based on number so sfo has least number ascending

         def sortParseAscening =  resSlurped.locations.cities.city.findAll { it.@id.toInteger() > 0}.sort {it.number}

         println("### printing parsed ascending order number ###  ${ sortParseAscening} ")


         assert sortSlurpAscening[0].name == 'sfo'

         // Parsed Xml--sorting based on number so sfo has least number descending

         def sortParseDescening =  resSlurped.locations.cities.city.findAll { it.@id.toInteger() > 0}.sort { a,b -> b.number.toInteger() <=>a.number.toInteger() }

         println("### printing slurped ascending order number ####  ${ sortParseDescening} ")

         assert sortSlurpDescening[0].name == 'chicago'

         /*
         * Manipulate the xml
          */
/*
         def parser = new XmlParser()

       //  resParsed.appendNode( new QName("bahrgav added"),[id:"10"], "modepalliadded")
          // parser.createNode(resParsed.locations.cities.city, new QName("bahrgav added"),[id:"10"])
         resParsed.locations.cities.children().find{it.name = 'cities'}.appendNode{city(id: "45"){
             number("123")
             name("assinfsncodnnc")
         }}


         def sortParseDesceningafter =  resParsed.locations.cities.city.findAll { it.@id.toInteger() > 2}
         println("### ************printing slurped ascending order number ####  ${ sortParseDesceningafter} ")

*/



    }



}
