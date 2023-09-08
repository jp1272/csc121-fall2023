;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname bookstore-methods3) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))

;; A Book is one of
;;   - PrintBook
;;   - AudioBook
;;   - OnlineBook

;; A PrintBook is (make-print-book String String Number)
(define-struct print-book (title author price))

;; An AudioBook is (make-audio-book String String Number Number)
(define-struct audio-book (title author price noCDs))

;; An OnlineBook is (make-online-book String String Number String)
(define-struct online-book (title author price url))




#| 
TEMPLATES:

;; book-func : Book ... -> ...
(define (book-func a-book ...)
  (cond [(print-book? a-book) ... (print-book-func a-book) ...]
        [(audio-book? a-book) ... (audio-book-func a-book) ...]
        [(online-book? a-book) ... (online-book-func a-book) ...]))

;; print-book-func : PrintBook ... -> ...
(define (print-book-func a-pb ...)
  ... (print-book-title a-pb) ...
  ... (print-book-author a-pb) ...
  ... (print-book-price a-pb) ... )

;; audio-book-func : AudioBook ... -> ...
(define (audio-book-func an-ab ...)
  ... (audio-book-title an-ab) ...
  ... (audio-book-author an-ab) ...
  ... (audio-book-price an-ab) ... 
  ... (audio-book-noCDs an-ab) ... )

;; online-book-func : OnlineBook ... -> ...
(define (online-book-func an-ob ...)
  ... (online-book-title an-ob) ...
  ... (online-book-author an-ob) ...
  ... (online-book-price an-ob) ... 
  ... (online-book-url an-ob) ... )
 
|#



;; EXAMPLES OF DATA

(define oms (make-print-book "Old Man and the Sea" "EH" 10))
(define eos (make-print-book "Elements of Style" "EBW" 20))
(define htdp (make-print-book "HtDP" "MF" 60))

(define oms-audio (make-audio-book "Old Man and the Sea" "EH" 10 2))

(define oms-online (make-online-book "Old Man and the Sea" "EH" 10 "gutenberg.org"))
(define htdp-online (make-online-book "HtDP" "MF" 0 "htdp.org"))




;; sale-price : Book -> Number
(check-expect (sale-price oms) 7)
(check-expect (sale-price oms-audio) 8)
(check-expect (sale-price oms-online) 10)
(check-expect (sale-price htdp-online) 0)

(define (sale-price a-book)
  (cond [(print-book? a-book) (print-book-sale-price a-book)]
        [(audio-book? a-book) (audio-book-sale-price a-book)]
        [(online-book? a-book) (online-book-sale-price a-book)]))


;; print-book-sale-price : PrintBook -> Number
(define (print-book-sale-price a-pb)
  (* .7 (print-book-price a-pb)))

;; audio-book-sale-price : AudioBook -> Number
(define (audio-book-sale-price an-ab)
  (* .8 (audio-book-price an-ab)))

;; online-book-sale-price : OnlineBook -> Number
(define (online-book-sale-price an-ob)
  (online-book-price an-ob))
