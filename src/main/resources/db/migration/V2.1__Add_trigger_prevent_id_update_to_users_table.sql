CREATE OR REPLACE FUNCTION prevent_id_update()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.id <> OLD.id THEN
        RAISE EXCEPTION 'Cannot update id field';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create a trigger to call the function before any update
CREATE TRIGGER prevent_id_update_trigger
BEFORE UPDATE ON users
FOR EACH ROW
EXECUTE FUNCTION prevent_id_update();
