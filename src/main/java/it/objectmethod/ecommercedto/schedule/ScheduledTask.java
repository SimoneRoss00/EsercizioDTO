package it.objectmethod.ecommercedto.schedule;

import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

//	@Autowired
//	private OrderService orderService;
//
//	Logger log = LoggerFactory.logger(ScheduledTask.class);
//
//	@Scheduled(cron = "${scheduler.cron.expression.orderTask}")
//	public void orderControl() throws IOException, ParseException {
//
//		File file = new File("order.csv");
//		FileWriter fileWriter = new FileWriter(file);
//		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -1);
//		String fakeDate = dateFormat.format(cal.getTime());
//		Date date = dateFormat.parse(fakeDate);
//		List<OrderDTO> orderDTOList = orderService.getDateOfYesterday(date);
//
//		for (OrderDTO orderDTO : orderDTOList) {
//			bufferedWriter.write(orderDTO.toString());
//			bufferedWriter.write("\n");
//		}
//		bufferedWriter.close();
//	}
//
//	@Scheduled(cron = "${scheduler.cron.expression.orderTaskReader}")
//	public void orderReader() throws IOException, ParseException {
//		File file = new File("order.csv");
//		FileReader fileReader = new FileReader(file);
//		BufferedReader bufferedReade = new BufferedReader(fileReader);
//		String line = bufferedReade.readLine();
//		OrderDTO orderDTO = new OrderDTO();
//		List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
//		while (!(line == null || line.trim().isEmpty())) {
//			log.info(line);
//			orderDTOList.add(orderDTO.articoloFactoryFromCsv(line));
//			line = bufferedReade.readLine();
//
//		}
//
//		bufferedReade.close();
//
//	}
}
