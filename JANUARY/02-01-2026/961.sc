object Solution {
    def repeatedNTimes(nums: Array[Int]): Int = {
        val seen = scala.collection.mutable.Set[Int]()
        nums.find { x =>
            if (seen.contains(x)) true
            else { seen.add(x); false }
        }.getOrElse(-1)
    }
}