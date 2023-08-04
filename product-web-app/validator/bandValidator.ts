interface Band {
    name: string;
    level: string;
    responsibilities: string;
  }
  
  export function validateBand(band: Band): string | null {
    if (band.name.length < 1) {
      return "name must be at least 1 characters";
    }
  
    if (band.level.length < 1) {
      return "level must be at least 1 character";
    }
  
    if (band.responsibilities.length < 1) {
      return "Responsibilities must be at least 1 character";
    }
  
  
    return null;
  }
  