(ns clojure-dataframe.core 
  (:require [tablecloth.api :as tc]
            [tech.v3.datatype.functional :as dfn]))

(println (tc/dataset {:V1 (take 9 (cycle [1 2]))
                     :V2 (range 1 10)
                     :V3 (take 9 (cycle [0.5 1.0 1.5]))
                     :V4 (take 9 (cycle ["A" "B" "C"]))}))

(tc/dataset nil {:column-names [:a :b]})

(tc/dataset [[:a 33] [:b 44] [:c 55]])

(tc/dataset {:layout :as-rows :column-name [:a :b]} (into-array (map int-array [[3 4 5] [7 6 9]])))

(-> (map int-array [[3 4 5] [7 6 9]])
    (into-array)
    (tc/dataset {:layout :as-rows :column-name [:a :b]}))

;; (tc/let-dataset [x (range 1 6)
;;                  y 1
;;                  z (dfn/+ x y)])

(def df
 (tc/dataset "https://vega.github.io/vega-lite/examples/data/seattle-weather.csv"))

(print (tc/columns df))

(print (tc/column df "date"))

(println (keys (tc/columns df :as-map)))

(println (take 2 (tc/rows df)))

(clojure.pprint/pprint (take 2 (tc/rows df :as-maps)))

