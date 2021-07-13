import java.io.{BufferedWriter, FileWriter, PrintWriter}
import java.util.UUID

object ScalaDemo {

  def main(args: Array[String]): Unit = {
    /* val stringList = List("aa","bb","cc")
    val out = for{
      str <- stringList
    } yield str
    print(out)

    //

    val mapA = Map ((1 -> "a"),(2, "b"), (3, "c"))
    val mapB = Map((1 -> "a"),(2, "b"), (4, "c"))

    val mapC = mapA.filter(a => !mapB.contains(a._1))
    println("mapC" +mapC)
  }

  val array2Dimension = Array.ofDim[String](2,2)
  array2Dimension(0)(0) = "elem1"
  array2Dimension(0)(1) = "elem2"
  array2Dimension(1)(0) = "elem3"
  array2Dimension(1)(1) = "elem4"
  for {
    x <- 0 to 1
    y <- 0 to 1
  }println(array2Dimension(x)(y))

  //println("a".toFloat)

  //DemoObj demo = new DemoObj();
  //println("a".asInstanceOf[Float])

  val (divisibleByTwo,divisibleNotByTwo) = List(1,2,3,4).partition(_ % 2 == 0)
  println(divisibleByTwo)
  println(divisibleNotByTwo)*/

    //  ************** batch request *********************** //
    val batch_request_insert = "insert into kpi_embedded_ops_analytics.batch_request "
    val batch_request_col = "(tenant_uuid, batch_id, batch_initiator, batch_submission_time, batch_type, error_text," +
      " originator_person_id, request_context, status_id)"

    val batch_request_values = " values (2d09ea27-6ea8-45ec-b32f-f07b34a150d5, "
    val batch_initiator = "'SYSTEM',"
    val submission_time = "'2020-05-09',"
    val batch_type = "'PAYPERIOD',"
    val error_text = null
    val originator_person_id = "0,"
    val request_context = "'[[{\"ORIGINATOR_PERSON_ID\":\"\",\"BATCH_DOMAIN\":\"[TIMEKEEPING]\",\"COMPUTE_LOCATIONS\":\"\",\"COMPUTE_OBJECTS\":\"ALL\",\"BATCH_INITIATOR\":\"SYSTEM\",\"EMPLOYEE_IDS\":[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,464,465,466,467,468,469,470,471,472,473,474,475,476,477,478,479,480,481,482,483,484,485,486,487,488,489,490,491,492,493,494,495,496,497,498,499,500,501,502,503,504,505,506,507,508,509,510,511,512,513,514,515,516,517,518,519,520,521,522,523,524,525,526,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,542,543,544,545,546,551,552,553,601,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,651,652,653,654,655,656,701,702],\"DATA_VERSIONID\":\"327416cd-63c4-11ea-a673-0242ac120002\",\"BATCH_ACTION_TYPE\":\"PAYPERIOD\",\"TIMEFRAME_ID\":[0,1,2]}]]',"
    val status_id = 8
    //  ************** batch increment *********************** //
    val insert = "insert into kpi_embedded_ops_analytics.batch_increment "
    val col = "(tenant_uuid, batch_id, increment_group_id, order_num, batch_increment_id, batch_increment_val," +
      " increment_end_time, increment_start_time, retry_count, status_id)"

    val values = " values (8fec8fa0-fae3-484c-a6b2-1fab61edc2c6, 184e91da-6744-41c7-a853-379a15391d3a, 03538a11-d502-4c26-bde9-235d7e4e6279,"
    var orderNum = 1
    // val inc_id = "9a977869-4e41-11ea-dd44-42010a03330b"
    val inc_id = "69-4e41-11ea-dd44-42010a03330b,"
    val inc_val = ",{start_date: '2020-02-03', end_date: '2020-02-07', timeframe_id: null, configversion_id: null, employees: {405, 406}, plan_id: 980c1208-4e41-11ea-dd44-42010a03330b, orgs: null, org_type: null, org_rollup_reset_required: False, dimension: 'EMPLOYEE', reference_group_ids: null},"
    val inc_end_time = "'2020-02-13',"
    val inc_start_time = "'2020-02-13',"
    val retry = "0,"
    val status = "5"
    val end = ");"

    //  ************** batch_run_history *********************** //

    val insert_history = "insert into kpi_embedded_ops_analytics.batch_run_history "
    val col_history = "(tenant_uuid, batch_submission_time, batch_id, batch_end_time, batch_increment_run_val, batch_initiator, batch_lastupdated_time," +
      " batch_start_time, batch_type, originator_person_id, retry_count, status_id)"

    val values_history = " values (ea318292-663f-4000-ae9a-f9e2c4e86d39," + submission_time
    val batch_id = UUID.randomUUID()
    val batch_incr_run_val = "{increment_group_id: 8c27a07f-98f8-11ea-a867-42010a03355b, order_nums: {2}, remaining_groups: ['8c292761-98f8-11ea-a867-42010a03355b', '8c2afc49-98f8-11ea-a867-42010a03355b', '8c3caf8a-98f8-11ea-a867-42010a03355b', '8c2863e7-98f8-11ea-a867-42010a03355b', '8c29c3b0-98f8-11ea-a867-42010a03355b', '8c28b219-98f8-11ea-a867-42010a03355b', '8c3d24be-98f8-11ea-a867-42010a03355b'], total_pending_count: 746, successful_count: 0, failed_count: 25, in_progress_count: 25, failed_groups: {'8c27a07f-98f8-11ea-a867-42010a03355b'}}"


    val writer = new PrintWriter(new FileWriter("batch_increment_15000.cql"))

    for (i <- 1 to 15000) {
      val finalQueryBatchIncrement = insert + col + values + orderNum + "," + UUID.randomUUID() +
        inc_val + inc_end_time + inc_start_time + retry + status + end

      val finalQueryBatchRequest = batch_request_insert + batch_request_col + batch_request_values +
        UUID.randomUUID() + "," + batch_initiator + submission_time + batch_type + error_text + "," + originator_person_id + request_context + status_id + end

      val finalQueryBatchRunHistory = insert_history + col_history + values_history + UUID.randomUUID() + "," + submission_time + batch_incr_run_val + "," +
        batch_initiator + submission_time + submission_time + batch_type + originator_person_id + retry + status + end
      if (i % 25 == 0) orderNum = orderNum + 1
      //println(finalQueryBatchRunHistory)
      //writer.write(finalQueryBatchRequest)
      // writer.println(finalQueryBatchIncrement)
    }
    //println(UUID.randomUUID())

    val a = "BATCH,,"
    val b = a.split(",")
    b.foreach(c => println("c"+c))
    writer.close()
  }
}
