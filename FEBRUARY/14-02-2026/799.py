class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        query_row += 1
        current_row, glasses = 1, [poured]
        while current_row != query_row:
            current_row += 1
            next_glasses = [0] * current_row
            for idx, champaign in enumerate(glasses):
                spill = max(0, champaign - 1) / 2
                next_glasses[idx] += spill
                next_glasses[idx + 1] += spill
            glasses = next_glasses
        return min(1, glasses[query_glass])