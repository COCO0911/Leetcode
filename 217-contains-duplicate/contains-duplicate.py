class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        hash_set = set()
        for number in nums: 
            if number in hash_set:
                return True
            else:
                hash_set.add(number)
        return False
        