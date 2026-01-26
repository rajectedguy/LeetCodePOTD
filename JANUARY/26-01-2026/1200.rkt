(define/contract (minimum-abs-difference arr)
  (-> (listof exact-integer?) (listof (listof exact-integer?)))
  (let ([a (sort arr <)])
    (define (min-diff lst)
      (cond [(or (null? lst) (null? (cdr lst))) +inf.0]
            [else (min (- (cadr lst) (car lst))
                       (min-diff (cdr lst)))]))
    (define (collect lst mn)
      (cond [(or (null? lst) (null? (cdr lst))) '()]
            [(= (- (cadr lst) (car lst)) mn)
             (cons (list (car lst) (cadr lst))
                   (collect (cdr lst) mn))]
            [else (collect (cdr lst) mn)]))
    (let ([mn (min-diff a)])
      (collect a mn))))