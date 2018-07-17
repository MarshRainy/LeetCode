import java.util.*;

public class Solution01800 {
	class Pair {
		public Pair(int num1, int num2, int index1, int index2) {
			this.num1 = num1;
			this.num2 = num2;
			this.index1 = index1;
			this.index2 = index2;
		}

		public int num1;
		public int num2;
		public int index1;
		public int index2;

	}

	private boolean ref(Pair p1, Pair p2) {
		if (p1.index1 == p2.index1 || p1.index1 == p2.index2 || p1.index2 == p2.index1 || p1.index2 == p2.index2) {
			return true;
		}
		return false;
	}

	class Four {
		public Four(Pair x, Pair y) {
			value = new int[4];
			value[0] = x.num1;
			value[1] = x.num2;
			value[2] = y.num1;
			value[3] = y.num2;
			Arrays.sort(value);
		}

		public int[] value = null;

		@Override
		public boolean equals(Object obj) {
			int[] value1 = ((Four) obj).value;
			for (int i = 0; i < 4; i++) {
				if (value1[i] != value[i]) {
					return false;
				}
			}
			return true;
		}

		@Override
		public int hashCode() {
			long sum = value[0] * 1 + value[1] * 3 + value[2] * 13 + value[3] * 17;
			return (int) (sum % Integer.MAX_VALUE);
		}

	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return new ArrayList<List<Integer>>();
		}

		// 生成数组对map
		Map<Integer, List<Pair>> pairSumToPair = new HashMap<Integer, List<Pair>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (!pairSumToPair.containsKey(sum)) {
					pairSumToPair.put(sum, new ArrayList<Pair>());
				}
				pairSumToPair.get(sum).add(new Pair(nums[i], nums[j], i, j));
			}
		}

		// 数据配对
		List<Integer> list = new ArrayList<Integer>();
		for (Integer integer : pairSumToPair.keySet()) {
			list.add(integer);
		}
		List<Four> result = new ArrayList<Four>();
		Set<Four> resultSet = new HashSet<Four>();
		for (int i : list) {
			if (target == i + i) {
				List<Pair> xList = pairSumToPair.get(i);
				if (xList != null && xList.size() > 0) {
					for (int tt = 0; tt < xList.size() - 1; tt++) {
						for (int rr = tt + 1; rr < xList.size(); rr++) {
							if (!ref(xList.get(tt), xList.get(rr))) {
//								result.add(new Four(xList.get(tt), xList.get(rr)));
								resultSet.add(new Four(xList.get(tt), xList.get(rr)));
							}
						}
					}
				}
			} else {
				List<Pair> xList = pairSumToPair.get(i);
				List<Pair> yList = pairSumToPair.get(target - i);
				if (xList != null && xList.size() > 0 && yList != null && yList.size() > 0) {
					for (Pair xPair : xList) {
						for (Pair yPair : yList) {
							if (!ref(xPair, yPair)) {
//								result.add(new Four(xPair, yPair));
								resultSet.add(new Four(xPair, yPair));
							}
						}
					}
				}
			}
			pairSumToPair.remove(i);
			pairSumToPair.remove(target - i);
		}

		// debug
//		for (Four four : resultSet) {
//			String string = "";
//			for (int i : four.value) {
//				string += i + "  ";
//			}
//			System.out.println(string);
//		}

		// 生成返回值
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		for (Four four : resultSet) {
			List<Integer> mm = new ArrayList<Integer>();
			for (int i : four.value) {
				mm.add(i);
			}
			ll.add(mm);
		}

		return ll;
	}
}
