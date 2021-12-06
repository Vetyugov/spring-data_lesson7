create table if not exists products (id bigserial primary key, name varchar(255), cost int);

insert into products (name, cost)
values
('bacon', 100),
('beef', 80),
('chicken', 90),
('duck', 100),
('ham', 80),
('lamb', 90),
('liver', 100),
('meat', 80),
('mutton', 90),
('ox tongue', 100),
('patridge', 80),
('pork', 90),
('poultry', 100),
('sausage', 80),
('tenderloin', 90),
('turkey', 100),
('veal', 80),
('venison', 90),
('cod', 80),
('eel', 90);