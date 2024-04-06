-- ApartmentComplex 데이터 삽입 (created_at, updated_at 포함)
INSERT INTO apartment_complex (name, created_at, updated_at) VALUES ('고덕아르테온', NOW(), NOW());
INSERT INTO apartment_complex (name, created_at, updated_at) VALUES ('삼익맨션', NOW(), NOW());
INSERT INTO apartment_complex (name, created_at, updated_at) VALUES ('롯데캐슬리버파크시그니처', NOW(), NOW());

-- FloorPlan 데이터 삽입 (created_at, updated_at 포함)
-- 고덕아르테온 평형 타입
INSERT INTO floor_plan (apartment_complex_id, type, is_expanded, exclusive_area, supply_area, image_url, created_at, updated_at) VALUES (1, '112A', false, 112.00, 149.00, 'https://example.com/floorplan/112A.jpg', NOW(), NOW());

-- 삼익맨션 평형 타입
INSERT INTO floor_plan (apartment_complex_id, type, is_expanded, exclusive_area, supply_area, image_url, created_at, updated_at) VALUES (2, '85A', false, 85.00, 114.00, 'https://example.com/floorplan/85A.jpg', NOW(), NOW());

-- 롯데캐슬리버파크시그니처 평형 타입
INSERT INTO floor_plan (apartment_complex_id, type, is_expanded, exclusive_area, supply_area, image_url, created_at, updated_at) VALUES (3, '112B', false, 112.00, 149.00, 'https://example.com/floorplan/112B.jpg', NOW(), NOW());
INSERT INTO floor_plan (apartment_complex_id, type, is_expanded, exclusive_area, supply_area, image_url, created_at, updated_at) VALUES (3, '112B', true, 112.00, 149.00, 'https://example.com/floorplan/112B_expanded.jpg', NOW(), NOW());

-- Address 데이터 삽입 (created_at, updated_at 포함)
-- 고덕아르테온 주소
INSERT INTO address (apartment_complex_id, road_address, jibun_address, created_at, updated_at) VALUES (1, '서울특별시 강동구 고덕로 360', '서울특별시 강동구 상일동 519', NOW(), NOW());
INSERT INTO address (apartment_complex_id, road_address, jibun_address, created_at, updated_at) VALUES (1, '서울특별시 강동구 고덕로 380', '서울특별시 강동구 상일동 520', NOW(), NOW());

-- 삼익맨션 주소
INSERT INTO address (apartment_complex_id, road_address, jibun_address, created_at, updated_at) VALUES (2, '서울특별시 강동구 상암로 224', '서울특별시 강동구 명일동 270', NOW(), NOW());
INSERT INTO address (apartment_complex_id, road_address, jibun_address, created_at, updated_at) VALUES (2, '서울특별시 강동구 상암로 225', '서울특별시 강동구 명일동 260-1', NOW(), NOW());

-- 롯데캐슬리버파크시그니처 주소
INSERT INTO address (apartment_complex_id, road_address, jibun_address, created_at, updated_at) VALUES (3, '서울특별시 광진구 뚝섬로 467', '서울특별시 광진구 자양동 236', NOW(), NOW());



