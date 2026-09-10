CREATE TABLE IF NOT EXISTS retail_transactions (
  id BIGSERIAL PRIMARY KEY,
  invoice_no VARCHAR(30) NOT NULL,
  stock_code VARCHAR(30) NOT NULL,
  description TEXT,
  quantity INTEGER NOT NULL,
  invoice_date TIMESTAMP NOT NULL,
  unit_price NUMERIC(10,2) NOT NULL,
  customer_id INTEGER,
  country VARCHAR(80)
);
CREATE INDEX IF NOT EXISTS idx_retail_customer ON retail_transactions(customer_id);
CREATE INDEX IF NOT EXISTS idx_retail_stock ON retail_transactions(stock_code);
CREATE INDEX IF NOT EXISTS idx_retail_invoice_date ON retail_transactions(invoice_date);

-- Deterministic portfolio/demo data: 541,909 transaction rows.
INSERT INTO retail_transactions
(invoice_no, stock_code, description, quantity, invoice_date, unit_price, customer_id, country)
SELECT
  'INV-' || LPAD((((g-1) / 7) + 1)::text, 6, '0'),
  'SKU-' || LPAD(((g % 4000) + 1)::text, 5, '0'),
  'Online Retail Item ' || ((g % 250) + 1),
  ((g % 8) + 1),
  TIMESTAMP '2024-01-01' + ((g % 525600) * INTERVAL '1 minute'),
  ROUND((2 + ((g % 5000) / 100.0))::numeric, 2),
  10000 + (g % 8000),
  CASE WHEN g % 5 = 0 THEN 'United Kingdom' ELSE 'Ireland' END
FROM generate_series(1, 541909) g
ON CONFLICT DO NOTHING;
