(define/contract (minimum-difference nums k)
  (-> (listof exact-integer?) exact-integer? exact-integer?)
  (if (<= k 1)
      0
      (let* ([s (sort nums <)]
             [n (length s)])
        (apply min
               (for/list ([i (in-range 0 (+ 1 (- n k)))])
                 (- (list-ref s (+ i k -1))
                    (list-ref s i)))))))